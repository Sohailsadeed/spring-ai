package com.spring.ai.config;

import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.ai.ChatMemoryApplication;
import org.slf4j.Logger;


	@Configuration
	public class Config {
		
		@Bean
		public ChatMemory chatMemory(JdbcChatMemoryRepository jdbcChatMemoryRepository) {
			return MessageWindowChatMemory.builder()
													.chatMemoryRepository(jdbcChatMemoryRepository)
													.maxMessages(14)
													.build();
		}
		@Bean
		public ChatClient chatClient(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory) {
			Logger logger = LoggerFactory.getLogger(ChatMemoryApplication.class);
			
			MessageChatMemoryAdvisor chatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();
			
			logger.info("Class of the Chat Memory: " + chatMemory.getClass().getName());
			return chatClientBuilder.defaultOptions(GoogleGenAiChatOptions.builder()
					.model("gemini-2.5-flash-lite")
					.temperature(0.2)
					.maxOutputTokens(256)
					.build())
					.defaultAdvisors(chatMemoryAdvisor, new SimpleLoggerAdvisor())
					.build();
		}	
	}