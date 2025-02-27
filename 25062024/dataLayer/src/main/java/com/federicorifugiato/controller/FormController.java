package com.federicorifugiato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.federicorifugiato.model.Prodotto;
import com.federicorifugiato.services.ProdottoService;

@Controller
@RequestMapping("/form")
public class FormController {
	
	@Autowired
	private ProdottoService prodottoService;
	
	@GetMapping
	public String getPage(Model model, @RequestParam(name = "id", required = false) Integer id) {
		
		Prodotto prodotto = id == null? new Prodotto() : prodottoService.getProdottoById(id);
		model.addAttribute("prodotto", prodotto);
		return "form";
	}
	
	@PostMapping
	public String postProdotto (@ModelAttribute("prodotto") Prodotto prodotto) {
		prodottoService.registraProdotto(prodotto);
		return "redirect:/";
	}
}
