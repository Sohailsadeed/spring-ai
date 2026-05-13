package com.spring.ai.config;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.ai.advisors.MyPersonalAdvisor;


@Configuration
public class Config {
	
	@Bean
	public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
		return chatClientBuilder
				.defaultAdvisors(new MyPersonalAdvisor(), new SimpleLoggerAdvisor(), new SafeGuardAdvisor(List.of("violence", "hate", "self-harm")))
				.defaultOptions(GoogleGenAiChatOptions.builder()
				.model("gemini-2.5-flash-lite")
				.temperature(0.7)
				.maxOutputTokens(2048)
				.build())
				.build();
	}
}