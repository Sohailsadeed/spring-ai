package com.spring.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {
	
	private ChatClient geminiChatClient;
	private ChatClient deepSeekChatClient;
	
	public ChatClientConfig(GoogleGenAiChatModel googleGenAiChatModel, DeepSeekChatModel deepSeekChatModel) {
		this.geminiChatClient = ChatClient.create(googleGenAiChatModel);
		this.deepSeekChatClient = ChatClient.create(deepSeekChatModel);
	}
	
	@Bean
	public ChatClient getGeminiChatClient() {
		return geminiChatClient;
	}
	
	@Bean
	public ChatClient getDeepSeekChatClient() {
		return deepSeekChatClient;
	}
}
