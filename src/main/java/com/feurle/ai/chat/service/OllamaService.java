package com.feurle.ai.chat.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class OllamaService {

    private final ChatClient chatClient;
    private final ToolCallbackProvider toolCallbackProvider;

    public OllamaService(ChatClient.Builder builder, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = builder.build();
        this.toolCallbackProvider = toolCallbackProvider;
    }

    public String chat(String userMessage) {
        return chatClient
                .prompt()
                .user(userMessage)
                .toolCallbacks(toolCallbackProvider.getToolCallbacks())
                .call()
                .content();
    }

    public Flux<String> chatStream(String userMessage) {
        return chatClient
                .prompt()
                .user(userMessage)
                .toolCallbacks(toolCallbackProvider.getToolCallbacks())
                .stream()
                .content();
    }
}
