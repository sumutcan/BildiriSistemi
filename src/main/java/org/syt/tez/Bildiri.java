package org.syt.tez;

import java.util.ArrayList;

public class Bildiri {
	
	private int id;
	private Yazar yazar;
	private ArrayList<Yazar> digerYazarlar;
	private String baslik;
	private String ozet;
	private ArrayList<String> anahtarKelimeler;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Yazar getYazar() {
		return yazar;
	}
	public void setYazar(Yazar yazar) {
		this.yazar = yazar;
	}
	public ArrayList<Yazar> getDigerYazarlar() {
		return digerYazarlar;
	}
	public void setDigerYazarlar(ArrayList<Yazar> digerYazarlar) {
		this.digerYazarlar = digerYazarlar;
	}
	public String getBaslik() {
		return baslik;
	}
	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}
	public String getOzet() {
		return ozet;
	}
	public void setOzet(String ozet) {
		this.ozet = ozet;
	}
	public ArrayList<String> getAnahtarKelimeler() {
		return anahtarKelimeler;
	}
	public void setAnahtarKelimeler(ArrayList<String> anahtarKelimeler) {
		this.anahtarKelimeler = anahtarKelimeler;
	}
	
}
