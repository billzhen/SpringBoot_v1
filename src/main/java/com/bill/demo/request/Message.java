package com.bill.demo.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {
    private String role = "user";
    private String content;
    public Message(String content){
        this.content = content;
    }
}
