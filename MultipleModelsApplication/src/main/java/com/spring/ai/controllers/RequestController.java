package com.spring.ai.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

	private ChatClient geminiChatClient;
	private ChatClient deepSeekChatClient;

	public RequestController(@Qualifier("getGeminiChatClient")ChatClient geminiChatClient,@Qualifier("getDeepSeekChatClient") ChatClient deepSeekChatClient) {
		this.geminiChatClient = geminiChatClient;
		this.deepSeekChatClient = deepSeekChatClient;
	}
	
	@RequestMapping("/chat")
	public String sendResponse(
								@RequestParam(value = "message", required = true) String message) {
		
		var response = geminiChatClient.prompt(message).call().content();
		return response;
	}
}
