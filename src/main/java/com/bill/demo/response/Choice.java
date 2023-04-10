package com.bill.demo.response;

import com.bill.demo.request.ChatResponseMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Choice implements Serializable {
    private Integer index;
    private String text;

    private ChatResponseMessage message;
    @JsonProperty("finish_reason")
    private String finishReason;
}




