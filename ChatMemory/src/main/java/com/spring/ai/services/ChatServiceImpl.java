package com.spring.ai.services;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Value;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired	
	private ChatClient chatClient;
	
	@Value("classpath:/prompts/system-message.st")
	private Resource systemMessage;
	
	@Value("classpath:/prompts/user-message.st")
	private Resource userMessage;
	@Override
	public String chat(String userInput) {
		
		SystemPromptTemplate systemTemplate = SystemPromptTemplate.builder()
																	.resource(systemMessage)
																	.variables(Map.of("technology", "Springboot"))
																	.build();
		PromptTemplate userTemplate = PromptTemplate.builder()
										.resource(userMessage)
										.variables(Map.of("question", userInput))
										.build();
		
		Prompt prompt = new Prompt(systemTemplate.createMessage(), userTemplate.createMessage());
		
		return chatClient.prompt(prompt).advisors(a -> a.param(ChatMemory.CONVERSATION_ID, "user")).call().content();
	}
}