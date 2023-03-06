package com.bill.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theokanning.openai.completion.chat.ChatMessage;
import lombok.Data;

import java.io.Serializable;

@Data
public class Choice implements Serializable {
    private Integer index;
    private String text;

    private ChatMessage message;
    @JsonProperty("finish_reason")
    private String finishReason;
}




