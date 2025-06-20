package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletResponse;


@RestController
public class GenAiControler {
	private final ChatService chatClient;
	private final RecipeSevice recipeSevice;
	private final ImageService imageService;

    public GenAiControler(ChatService chatClient,RecipeSevice recipeSevice,ImageService imageService) {
        this.chatClient = chatClient;
        this.recipeSevice=recipeSevice;
        this.imageService=imageService;
    }

    // POST endpoint to receive prompt and return AI response
//    @PostMapping("ask-ai")
//    public String getResponse(@RequestBody String prompt) {
//        return chatClient.getResponce(prompt);
//    }

    @GetMapping("ask-ai")
    public CompletableFuture<String> getResponseFromQuery(@RequestParam String prompt) {
    	return chatClient.getResponseAsync(prompt);
    }
    
    @GetMapping("recipe-creator")
    public CompletableFuture<String> recipeCreator(
            @RequestParam String ingredients,
            @RequestParam(defaultValue = "any") String cuisine,
            @RequestParam(defaultValue = "") String dietaryRestriction) {

        return recipeSevice.createRecipeAsync(ingredients, cuisine, dietaryRestriction);
    }

    
    
    @GetMapping("/generate-image")
    public ResponseEntity<List<String>> generateImage(HttpServletResponse response, @RequestParam String prompt) {
    	ImageResponse imageResponse=imageService.generateImage(prompt);
    	
    	List<String> imageUrls=imageResponse.getResults().stream().map(result -> result.getOutput().getUrl()).toList();
    	
    	return ResponseEntity.ok(imageUrls);
    }
}
