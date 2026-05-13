package com.spring.ai.services;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
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

		return chatClient
				.prompt()
				.system(system-> system.text(systemMessage).param("technology", "Springboot"))
				.user(user -> user.text(userMessage).params(Map.of("question",userInput)))
				.call()
				.content();
	}
}
