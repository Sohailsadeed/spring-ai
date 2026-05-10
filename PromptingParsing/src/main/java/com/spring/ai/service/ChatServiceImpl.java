package com.spring.ai.service;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.spring.ai.entity.Language;

@Service
public class ChatServiceImpl implements ChatService {
	
private ChatClient chatClient;
	
	public ChatServiceImpl(ChatModel chatModel) {
		System.out.println(chatModel.getClass().getName());
		this.chatClient = ChatClient.builder(chatModel).build();
	}
	
	@Override
	public List<Language> chat(String query) {
//		var metaDeta = chatClient.prompt()
//				.system("You are an top IT recruiter")
//				.user("Provide suggstions for a Student aiming to be an AI Engineer")			
//				.call()
//				.chatResponse()
//				.getMetadata();;
//		System.out.println(metaDeta);
//				return "";
//		// .content() is equivalent to .grtResult().getOutput().getContent()
		
		List<Language> languages = chatClient.prompt()
					.system("You are a Linguist")
					.user(query)
					.call()
					.entity(new ParameterizedTypeReference<List<Language>>() {});
		
		return languages;
	}
}
