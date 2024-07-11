package com.federicorifugiato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.federicorifugiato.model.Ordine;
import com.federicorifugiato.services.OrdineService;

@Controller
@RequestMapping
public class OrdineController {
	@Autowired
	private OrdineService ordineService;
	
	@GetMapping("/ordini")
	public String getPage (Model model) {
		
		List<Ordine> ordini = ordineService.getOrdini();
		for(Ordine ordine : ordini) {
			System.out.println(ordine.getId());
		}
		model.addAttribute("ordini", ordini);
		
		return "ordini";
	}
	
	@GetMapping("/cancellaOrdine")
	public String cancellaOrdine (@RequestParam("id") int id) {
		
		ordineService.cancellaOrdine(id);
		
		return "redirect:/ordini";
	}
}
