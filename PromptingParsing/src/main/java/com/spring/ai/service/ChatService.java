package com.spring.ai.service;

import java.util.List;

import com.spring.ai.entity.Language;

public interface ChatService {
	public List<Language> chat(String query);
}
