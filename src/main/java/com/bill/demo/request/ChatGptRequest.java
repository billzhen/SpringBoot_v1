package com.bill.demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theokanning.openai.completion.chat.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptRequest implements Serializable {
    @JsonProperty("model")
    private String model;
//    private String prompt;
//    @JsonProperty("messages")
//    private List<ChatMessage> messages;

    private String prompt;

    @JsonProperty("max_tokens")
    private Integer maxTokens;

//    @JsonProperty("n")
//    private Integer n;

//    @JsonProperty("logit_bias")
//    private HashMap logitBias;


}




