package org.syt.tez;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.taglibs.standard.extra.spath.Step;
import org.springframework.stereotype.Service;

@Service("kisiService")
public class KisiService {

	private Connection connection;
	private String database = "/home/umutcan/bildiridb";
	
	public KisiService() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.hsqldb.jdbcDriver");
		connection = DriverManager.getConnection("jdbc:hsqldb:"+database, "SA", "");
	}
	
	public void ekle(String adSoyad, String email, String sifre, String adres, String kurum, String tip) throws SQLException
	{
		Statement stmt = null;
		try {
			stmt = connection.createStatement();

		String sql = "INSERT INTO Kisi (AdSoyad,Sifre, Email, Adres, Kurum,Tip) VALUES ("+"'"+adSoyad+"'"+",'"+sifre+"','"+email+"','"+adres+"','"+kurum+"','"+tip+"')";
		int i = stmt.executeUpdate(sql);
		
		if (i == -1)
			throw new SQLException("Kisi kaydi eklenemedi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			stmt.close();
			connection.close();
		}
		
		
		
		
	}
	
	public Kisi login(String email, String sifre)
	{
		String queryString="SELECT * FROM Kisi WHERE Email = '"+email+"' and Sifre='"+sifre+"'";
		ResultSet results = null;
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			
			results = stmt.executeQuery(queryString);
			
			if (results.next())
			{
				Kisi oturum = null;
				if (results.getString("tip") != null)
				{
					if (results.getString("tip").equals("hakem"))
					{
						oturum = new Hakem();
					   ((Hakem)oturum).setKurum(results.getString("Kurum"));
			
							   
					}else if (results.getString("tip").equals("yazar"))
					{
						oturum = new Yazar();
					   ((Yazar)oturum).setKurum(results.getString("Kurum"));
					   ((Yazar)oturum).setKurum(results.getString("Adres"));
 
							   
					}
					else
					{
						oturum = new  Yonetici();
	
					}
					
					   oturum.setEmail(email);
					   oturum.setSifre(sifre);
					   oturum.setAdSoyad(results.getString("AdSoyad"));
					   oturum.setId(results.getInt("ID"));
					   
					   return oturum;
				}
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				results.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
}
