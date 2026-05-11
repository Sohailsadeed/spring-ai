package com.spring.ai.service;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired	
	private ChatClient chatClient;
	
	@Override
	public String chat(String userInput) {
		
//		PromptTemplate template = PromptTemplate.builder()
//					                .template("You are a Geographer. Answer the following question: {question}, also tell me{query}")
//					                .build();
//		
//		String renderedPrompt = template.render(Map.of("question", userInput, "query","which species do they belong to?"));
//		Prompt prompt = new Prompt(renderedPrompt);
//		
//		return chatClient
//				.prompt(prompt)
//				.call()
//				.chatResponse()
//				.getResult()
//				.getOutput()
//				.getText();
		
		
		
//		SystemPromptTemplate systemPromptTemplate = SystemPromptTemplate.builder()
//									.template("You are a Geographer.")
//									.build();	
//		Message systemMessage = systemPromptTemplate.createMessage();
//		
//		PromptTemplate userPromptTemplate = PromptTemplate.builder()
//									.template("Answer the following question: {question}")
//									.build();
//		Message userMessage = userPromptTemplate.createMessage(Map.of("question", userInput));
//		
//		Prompt prompt = new Prompt(systemMessage, userMessage);
//		return chatClient
//				.prompt(prompt)
//				.call()
//				.chatResponse()
//				.getResult()
//				.getOutput()
//				.getText();
//		
		
		return chatClient
				.prompt()
				.system(system-> 
				system.text("You are a member of core committee of Pivotal Software team (specifically lead by Phil Webb) that developed {technology}").param("technology", "Springboot"))
				.user(user -> user.text("Answer the following question: {question}").params(Map.of("question",userInput)))
				.call()
				.content();
	}
}
