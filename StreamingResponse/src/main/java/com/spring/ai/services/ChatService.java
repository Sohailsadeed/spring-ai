package com.spring.ai.services;

import reactor.core.publisher.Flux;

public interface ChatService {
	public String chat(String userInput);

	public Flux<String> streamChat(String userInput);
}
