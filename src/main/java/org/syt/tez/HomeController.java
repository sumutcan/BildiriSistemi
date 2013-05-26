package org.syt.tez;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("oturum")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {

		return new ModelAndView("home","command",new Kisi());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("command")Kisi kisi, ModelMap model)
	{
		KisiService service = null;
		try {
			service = new KisiService();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Kisi oturum = service.login(kisi.getEmail(), kisi.getSifre());
		
		if (oturum != null)
		{
			model.addAttribute("oturum",oturum);
			
			if (oturum instanceof Hakem)
				return "hakem/home";
			else if (oturum instanceof Yazar)
				return "yazar/home";
			else
				return "yonetici/home";
		}
			
			
		
		return "home";
		
	}
	
	@RequestMapping(value="/registeration", method = RequestMethod.GET)
	public ModelAndView registeration()
	{
		return new ModelAndView("kayit","command", new Kisi());
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("command")Kisi kisi, 
			@RequestParam(value="tip", required= true) String tip,
			@RequestParam("adres") String adres,
			@RequestParam("kurum") String kurum) throws SQLException
	{
		
		Kisi kaydolacakKisi = null;
		KisiService service = null;
		try {
			service = new KisiService();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (tip.equals("hakem"))
		{
			kaydolacakKisi = new Hakem();
			kaydolacakKisi.setAdSoyad(kisi.getAdSoyad());
			kaydolacakKisi.setEmail(kisi.getEmail());
			kaydolacakKisi.setSifre(kisi.getSifre());
			((Hakem)kaydolacakKisi).setKurum(kurum);
			try {
				service.ekle(kaydolacakKisi.getAdSoyad(), kaydolacakKisi.getEmail(), kaydolacakKisi.getSifre(), null, ((Hakem)kaydolacakKisi).getKurum(), "hakem");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (tip.equals("yazar"))
		{
			kaydolacakKisi = new Yazar();
			kaydolacakKisi.setAdSoyad(kisi.getAdSoyad());
			kaydolacakKisi.setEmail(kisi.getEmail());
			kaydolacakKisi.setSifre(kisi.getSifre());
			((Yazar)kaydolacakKisi).setKurum(kurum);
			((Yazar)kaydolacakKisi).setAdres(adres);
			service.ekle(kaydolacakKisi.getAdSoyad(), kaydolacakKisi.getEmail(), kaydolacakKisi.getSifre(), ((Yazar)kaydolacakKisi).getAdres(), ((Yazar)kaydolacakKisi).getKurum(), "yazar");
		}else
		{
			kaydolacakKisi = new Yonetici();
			kaydolacakKisi.setAdSoyad(kisi.getAdSoyad());
			kaydolacakKisi.setEmail(kisi.getEmail());
			kaydolacakKisi.setSifre(kisi.getSifre());
			service.ekle(kaydolacakKisi.getAdSoyad(), kaydolacakKisi.getEmail(), kaydolacakKisi.getSifre(), null, null, "yonetici");
		}
		
				
		return "kayitBasarili";
	}
	
	
}
