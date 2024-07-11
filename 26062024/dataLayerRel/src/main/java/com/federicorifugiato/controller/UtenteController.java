package com.federicorifugiato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.federicorifugiato.dto.UtenteDto;
import com.federicorifugiato.model.Utente;
import com.federicorifugiato.services.UtenteService;

@Controller
@RequestMapping
public class UtenteController {
	@Autowired
	private UtenteService utenteService;
	
	@GetMapping("/utenti")
	public String getPage (Model model) {
		
		List<Utente> utenti = utenteService.getUtenti();
		List<UtenteDto> utentiDto = utenteService.getUtentiDto();
		model.addAttribute("utenti", utenti);
		
		return "utenti";
	}
	
	@GetMapping("/cancellaUtente")
	public String cancellaUtente (@RequestParam("id") int id) {
		
		utenteService.cancellaUtente(id);
		
		return "redirect:/utenti";
	}
}
