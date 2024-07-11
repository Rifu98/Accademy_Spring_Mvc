package com.federicorifugiato.homecontroller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/secondo")
public class SecondoController {
	
	@GetMapping
	public String getSecondo (Model model) {
		return "secondo";
	}
}
