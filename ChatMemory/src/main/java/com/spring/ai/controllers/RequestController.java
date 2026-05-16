package com.spring.ai.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ai.services.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class RequestController {

	@Autowired
	private ChatService chatService;
	@PostMapping("/chat")
	public ResponseEntity<String> chat(@RequestParam String userInput, 
										@RequestHeader String conversationId) {
		return ResponseEntity.ok(chatService.chat(userInput, conversationId));
	}
}