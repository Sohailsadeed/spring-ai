package com.spring.ai.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RequestController {
	
	private ChatClient chatClient;
	
	public RequestController(ChatModel chatModel) {
		System.out.println(chatModel.getClass().getName());
		this.chatClient = ChatClient.builder(chatModel).build();
	}
	
	@RequestMapping("/chat")
	public String sendResponse(
								@RequestParam(value = "message", required = true) String message) {
		
		var response = chatClient.prompt(message).call().content();
		return response;
	}
}