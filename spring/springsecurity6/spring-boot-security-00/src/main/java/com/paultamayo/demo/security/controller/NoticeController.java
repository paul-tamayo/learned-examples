package com.paultamayo.demo.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

	@GetMapping("/notice")
	public String getNotices() {
		return "Aquí esta las noticias...";
	}
}
