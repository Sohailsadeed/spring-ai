package com.spring.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
	
	@Bean
	public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
		return chatClientBuilder.defaultOptions(GoogleGenAiChatOptions.builder()
				.model("gemini-2.5-flash-lite")
				.temperature(0.7)
				.maxOutputTokens(2048)
				.build())
				.build();
	}
	
}
