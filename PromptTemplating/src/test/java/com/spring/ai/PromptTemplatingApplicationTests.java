package com.spring.ai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.ai.service.ChatService;

@SpringBootTest
class PromptTemplatingApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private ChatService chatService;
	@Test
	void testPromptRenderer() {
		var output = chatService.chat("How does Springboot autoinitialize beans in the IOC when the application starts?");
		System.out.println(output);
	}
}
