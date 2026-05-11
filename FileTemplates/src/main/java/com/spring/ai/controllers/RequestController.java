package com.spring.ai.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class RequestController {

	@PostMapping("/chat")
	public ResponseEntity<String> chat(){
		return ResponseEntity.ok("Hello from the chat endpoint!");
	}
}
