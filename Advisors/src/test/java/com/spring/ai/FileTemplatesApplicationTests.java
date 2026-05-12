package com.spring.ai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.ai.services.ChatService;

@SpringBootTest
class FileTemplatesApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private ChatService chatService;
	@Test
	void testChatService() {
		System.out.println("Testing ChatService...");
		var response = chatService.chat("When I create a resource in springboot in a subfolder prompts of resources, how does springboot know it is stored in the resources folder as I specify the classpath after resources");
		System.out.println(response);}
}
