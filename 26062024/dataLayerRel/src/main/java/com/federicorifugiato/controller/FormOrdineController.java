package com.federicorifugiato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.federicorifugiato.exceptions.UserNotFoundException;
import com.federicorifugiato.model.Ordine;
import com.federicorifugiato.services.OrdineService;

@Controller
@RequestMapping("/formOrdine")
public class FormOrdineController {
	
	@Autowired
	private OrdineService ordineService;
	
	@GetMapping
	public String getPage(Model model, @RequestParam(name = "id", required = false) Integer id) {
		
		Ordine ordine = id == null? new Ordine() : ordineService.getOrdineById(id);
		model.addAttribute("ordine", ordine);
		return "formOrdine";
	}
	
	@PostMapping
	public String postOrdine (@ModelAttribute("ordine") Ordine ordine, Model model) {
		try {
			ordineService.registraOrdine(ordine);
			return "redirect:/ordini";
		} catch (UserNotFoundException e) {
            model.addAttribute("error", "Utente non trovato");
    		return "formOrdine";
		} 
	}
}
