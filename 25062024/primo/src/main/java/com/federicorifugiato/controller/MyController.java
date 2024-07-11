package com.federicorifugiato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.federicorifugiato.model.User;
import com.federicorifugiato.services.UtenteService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
	
	@Autowired
	private UtenteService utenteService;

	@GetMapping("/")
	public String getPage (Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "index";
		
	}
	
	@PostMapping("/")
	public String registraUtente (@Valid @ModelAttribute("user") User user, BindingResult result) {
		
		if (result.hasErrors()) {
			return "index";
		}
		
		utenteService.registrazioneUtente(user);
		return "redirect:/";
	}
}
