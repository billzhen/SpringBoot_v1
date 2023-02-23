package com.bill.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.demo.request.BotRequest;
import com.bill.demo.response.ChatGptResponse;
import com.bill.demo.service.BotService;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchGPT{
    private final BotService botService;
    @Autowired
    Environment env;

    private static final String MAIN_PAGE = "index";

    @RequestMapping({"/","/index","/index.html"})
    public String welcome() {
        return MAIN_PAGE;
        
    }
    @RequestMapping("/gpt")
    public void searchGPT(){
        String token = env.getProperty("OPENAI_TOKEN");
        OpenAiService service = new OpenAiService(token);

        System.out.println("\nCreating completion...");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("How old of America?")
                .model("text-davinci-003")
                .maxTokens(300)
                .temperature(0.5)
                .topP(1.0)
                .echo(true)
                .build();
        List<CompletionChoice> response = service.createCompletion(completionRequest).getChoices();
        response.forEach(System.out::println);
        System.out.println("Done!");
    }

    @PostMapping("/send")
    public ChatGptResponse sendMessage(@RequestBody BotRequest botRequest) {
        return botService.askQuestion(botRequest);
    }

}