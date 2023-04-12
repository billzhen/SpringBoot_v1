package com.bill.demo.controller;


import com.bill.demo.request.BotRequest;
import com.bill.demo.request.ProgramRequest;
import com.bill.demo.response.ChatGptResponse;
import com.bill.demo.service.BotService;
import com.bill.demo.service.CreateModuleService;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/new")
public class CreateModule {
    private final CreateModuleService createModuleService;
    @Autowired
    Environment env;

    private static final String MAIN_PAGE = "index";

    @RequestMapping("/create")
    public void createClass(@RequestBody ProgramRequest programRequest){
        System.out.println("Bill inside create class.");
        createModuleService.createModule(programRequest);
    }


}