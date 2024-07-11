package com.federicorifugiato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.federicorifugiato.model.Prodotto;
import com.federicorifugiato.services.ProdottoService;

@Controller
@RequestMapping
public class ProdottoController {
	@Autowired
	private ProdottoService prodottoService;
	
	@GetMapping("/prodotti")
	public String getPage (Model model) {
		
		List<Prodotto> prodotti = prodottoService.getProdotti();
		model.addAttribute("prodotti", prodotti);
		
		return "prodotti";
	}
	
	@GetMapping("/cancellaProdotto")
	public String cancellaProdotto (@RequestParam("id") int id) {
		
		prodottoService.cancellaProdotto(id);
		
		return "redirect:/prodotti";
	}
}
