package com.spring.ai.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ai.services.ChatService;

import reactor.core.publisher.Flux;

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
	
	@GetMapping("/stream")
	public ResponseEntity<Flux<String>> streamChat(@RequestParam("query") String userInput) {
	    return ResponseEntity.ok(chatService.streamChat(userInput));
	}
}
