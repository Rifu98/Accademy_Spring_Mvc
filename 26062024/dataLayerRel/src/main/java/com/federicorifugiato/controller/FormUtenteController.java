package com.federicorifugiato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.federicorifugiato.model.Utente;
import com.federicorifugiato.services.UtenteService;


@Controller
@RequestMapping("/formUtente")
public class FormUtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@GetMapping
	public String getPage(Model model, @RequestParam(name = "id", required = false) Integer id) {
		
		Utente utente = id == null? new Utente() : utenteService.getUtenteById(id);
		model.addAttribute("utente", utente);
		return "formUtente";
	}
	
	@PostMapping
	public String postUtente (@ModelAttribute("utente") Utente utente) {
		utenteService.registraUtente(utente);
		return "redirect:/utenti";
	}
}
