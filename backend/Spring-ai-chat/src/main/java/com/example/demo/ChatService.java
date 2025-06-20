package com.example.demo;

import java.util.concurrent.CompletableFuture;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
	private final OllamaChatModel chatModel;

	public ChatService(OllamaChatModel chatModel) {
		this.chatModel = chatModel;
	}
	
	@Async
	public CompletableFuture<String> getResponseAsync(String prompt) {
		String response = chatModel.call(prompt);
		String cleanedResponse = cleanResponse(response);
	    return CompletableFuture.completedFuture(cleanedResponse);
	}


	private String cleanResponse(String input) {
	    // Remove <think>...</think> tags and their contents
	    return input.replaceAll("<think>.*?</think>", "")
	                .replaceAll("<think.*?>", "") // Handles orphan <think>
	                .replaceAll("</think>", "")   // Handles orphan </think>
	                .trim();
	}
}
