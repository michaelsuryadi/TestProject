package com.spring.test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Mahasiswa;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String test(Locale locale, Model model){
		logger.info("Welcome Test! The client locale is {}.", locale);
		
		List<Mahasiswa> data = new ArrayList<Mahasiswa>();
		Mahasiswa mhs = new Mahasiswa();
		mhs.setNim("1110007");
		mhs.setNama("Michael");
		mhs.setJurusan("IF");
		data.add(mhs);
		
		model.addAttribute("welcome",data);
		
		return "test";
	}
	
}
