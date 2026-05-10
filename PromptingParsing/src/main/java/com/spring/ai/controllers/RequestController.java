package com.spring.ai.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ai.entity.Language;
import com.spring.ai.service.ChatService;

@RestController
@RequestMapping
public class RequestController {
	
	private ChatService chatService;
	public RequestController(ChatService chatService) {
		this.chatService = chatService;
	}
	
	@RequestMapping("/chat")
	public List<Language> sendResponse(@RequestParam(value = "query", required = true) String query) {
		
		return chatService.chat(query);
	}
}