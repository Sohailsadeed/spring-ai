package com.spring.ai.service;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.spring.ai.entity.Language;

@Service
public class ChatServiceImpl implements ChatService {
	
@Autowired	
private ChatClient chatClient;
	
	@Override
	public List<Language> chat(String query) {
//		var metaDeta = chatClient.prompt()
//				.system("You are an top IT recruiter")
//				.user("Provide suggstions for a Student aiming to be an AI Engineer")			
//				.call()
//				.chatResponse()
//				.getMetadata()
//				.getModel();
//		System.out.println(metaDeta);
//				return "";
		
//		.content() is equivalent to .grtResult().getOutput().getContent()
		
		List<Language> languages = chatClient.prompt()
					.user(query)
					.call()
					.entity(new ParameterizedTypeReference<List<Language>>() {});
		
		return languages;
	}
}
