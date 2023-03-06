package com.bill.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ChatModel implements Serializable {

    private String role;

    private String content;

    public ChatModel(String role, String content) {
        this.role = role;
        this.content = content;
    }

}
