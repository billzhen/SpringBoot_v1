package com.bill;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class ChatCompletionTest {

    String token = System.getenv("OPENAI_TOKEN");
    OpenAiService service = new OpenAiService(token);

    @Test
    void createChatCompletion() {
        final List<ChatMessage> messages = new ArrayList<>();  // java version agnostic
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "You are a dog and will speak as such.");
        messages.add(systemMessage);

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(5)
                .maxTokens(50)
                .logitBias(new HashMap<>())
                .build();

        List<ChatCompletionChoice> choices = service.createChatCompletion(chatCompletionRequest).getChoices();
//        assertEquals(5, choices.size());

    }
    public static void main(String[] args) {
        final List<ChatMessage> messages = new ArrayList<>();  // java version agnostic
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "You are a dog and will speak as such.");
        messages.add(systemMessage);
        String token = "sk-D6QagXqjuOg3TRnFORl1T3BlbkFJJDhfkP6kNFUDFIHs8D5Zhijo";
        OpenAiService service = new OpenAiService(token);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(5)
                .maxTokens(50)
                .logitBias(new HashMap<>())
                .build();

        List<ChatCompletionChoice> choices = service.createChatCompletion(chatCompletionRequest).getChoices();
        service.createChatCompletion(chatCompletionRequest).getChoices().forEach(System.out::println);
    }
}