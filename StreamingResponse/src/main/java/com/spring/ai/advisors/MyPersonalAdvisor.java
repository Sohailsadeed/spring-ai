package com.spring.ai.advisors;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisor;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisorChain;

import reactor.core.publisher.Flux;

public class MyPersonalAdvisor implements CallAdvisor, StreamAdvisor{

	private Logger logger = LoggerFactory.getLogger(MyPersonalAdvisor.class);
	@Override
	public String getName() {
		
		return this.getClass().getSimpleName();
	}

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
		
		logger.info("Advisor: " + getName());
		logger.info("MyPersonalAdvisor - Before calling the API");
		logger.info("Request: "+ chatClientRequest.prompt().getInstructions());
		ChatClientResponse response = callAdvisorChain.nextCall(chatClientRequest);
		logger.info("MyPersonalAdvisor - After calling the API");
		logger.info("Totak tokens consumed for request(Prompt Tokens): "+ response.chatResponse().getMetadata().getUsage().getPromptTokens());
		logger.info("Total tokens consumed for response(Completion Tokens): "+ response.chatResponse().getMetadata().getUsage().getCompletionTokens());
		logger.info("Total tokens consumed for request + response(Total Tokens): "+ response.chatResponse().getMetadata().getUsage().getTotalTokens());
		return response;
	}

	@Override
	public Flux<ChatClientResponse> adviseStream(ChatClientRequest chatClientRequest,
			StreamAdvisorChain streamAdvisorChain) {
		
		Flux<ChatClientResponse> response = streamAdvisorChain.nextStream(chatClientRequest);
			
		return response;
	}

}
