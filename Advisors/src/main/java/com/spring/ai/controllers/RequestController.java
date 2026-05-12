package com.spring.ai.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ai.services.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class RequestController {

	@Autowired
	private ChatService chatService;
	@PostMapping("/chat")
	public ResponseEntity<String> chat(@RequestBody String userInput) {
		return ResponseEntity.ok(chatService.chat(userInput));
	}
}
