package com.federicorifugiato.homecontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.federicorifugiato.model.Articolo;
import com.federicorifugiato.service.ArticoloService;

@Controller
public class HomeController {
	
	@Autowired
	private ArticoloService articoloService;
	
	@GetMapping
	public String getHome (Model model) {
		model.addAttribute("title", "registrazione");
		model.addAttribute("name", "fede");
		List<Articolo> catalogo = articoloService.getCatalogo();
		model.addAttribute("catalogo", catalogo);
		return "index";
	}
}
