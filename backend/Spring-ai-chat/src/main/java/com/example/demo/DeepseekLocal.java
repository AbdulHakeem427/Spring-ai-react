package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class DeepseekLocal {
	private final ChatClient chatClient;

    public DeepseekLocal(@Qualifier("ollamaChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }
    
    
    @GetMapping("/deepseeklocal/{m}")
    public String chat(@PathVariable String m) {
    	return chatClient
    			.prompt()
    			.user(m)
    			.call()
    			.content();
    }
}
