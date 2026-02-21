package com.feurle.ai.chat.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class OllamaService {

    private final ChatClient chatClient;

    public OllamaService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String chat(String userMessage) {
        return chatClient
                .prompt()
                .user(userMessage)
                .tools()
                .call()
                .content();
    }

    public Flux<String> chatStream(String userMessage) {
        return chatClient
                .prompt()
                .user(userMessage)
                .stream()
                .content();
    }
}
