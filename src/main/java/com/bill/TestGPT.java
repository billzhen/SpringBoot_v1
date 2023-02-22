package com.bill;

import java.util.Arrays;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

public class TestGPT {
    public static void main(String[] args) {
        String token = "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";
        OpenAiService service = new OpenAiService(token);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("How old of America?")
                .model("ada")
                .echo(true)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
