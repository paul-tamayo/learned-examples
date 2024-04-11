package com.paultamayo.demo.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

	@GetMapping("/my-balance")
	public String getBalanceDetails() {
		return "Balance a detalle...";
	}

	@GetMapping("/home")
	public String home() {
		return "Home";
	}
}
