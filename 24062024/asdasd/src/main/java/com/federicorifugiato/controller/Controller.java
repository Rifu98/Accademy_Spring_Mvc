package com.federicorifugiato.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	@GetMapping
	public String aaa () {
		return "index";
	}
}
