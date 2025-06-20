package com.example.demo;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RecipeSevice {
    private final OllamaChatModel chatModel;

    public RecipeSevice(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Async
    public CompletableFuture<String> createRecipeAsync(String ingredients, String cuisine, String dietaryRestrictions) {
        String template = """
            You are a professional chef.

            Without any inner thoughts or commentary, generate only a clean, formatted recipe.

            **Instructions:**
            - Use these ingredients: {ingredients}
            - Cuisine: {cuisine}
            - Dietary restrictions: {dietaryRestrictions}

            **Format the output as:**
            - Recipe Title
            - Ingredients (with quantities)
            - Step-by-step Instructions
            """;

        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, Object> params = Map.of(
            "ingredients", ingredients,
            "cuisine", cuisine,
            "dietaryRestrictions", dietaryRestrictions
        );

        Prompt prompt = promptTemplate.create(params);
        String rawResponse = chatModel.call(prompt).getResult().getOutput().getText();

        return CompletableFuture.completedFuture(cleanResponse(rawResponse));
    }

    private String cleanResponse(String input) {
        return input.replaceAll("(?s)<think.*?>.*?</think>", "")
                    .replaceAll("(?s)<think.*?>", "")
                    .replaceAll("</think>", "")
                    .trim();
    }
}
