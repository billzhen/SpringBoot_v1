package com.bill.demo.service;

import com.bill.demo.request.Message;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bill.demo.config.ChatGptConfig;
import com.bill.demo.request.BotRequest;
import com.bill.demo.request.ChatGptRequest;
import com.bill.demo.response.ChatGptResponse;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class BotServiceImpl implements BotService {

    private static RestTemplate restTemplate = new RestTemplate();


    //    Build headers
    public HttpEntity<ChatGptRequest> buildHttpEntity(ChatGptRequest chatRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(ChatGptConfig.MEDIA_TYPE));
        headers.add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + ChatGptConfig.API_KEY);
        return new HttpEntity<>(chatRequest, headers);
    }

    //    Generate response
    public ChatGptResponse getResponse(HttpEntity<ChatGptRequest> chatRequestHttpEntity) {
        ResponseEntity<ChatGptResponse> responseEntity = restTemplate.postForEntity(
                ChatGptConfig.URL,
                chatRequestHttpEntity,
                ChatGptResponse.class);
        System.out.println("Bill responseEntity: " + responseEntity);
        return responseEntity.getBody();
    }
    public ChatGptResponse httpPost(String message){
        RestTemplate restTemplate=new RestTemplate();
        // 设置请求body
        List<ChatMessage> messages = new ArrayList<>();  // java version agnostic
        ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), message);
        messages.add(systemMessage);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("model", ChatGptConfig.MODEL);
        map.put("max_tokens", ChatGptConfig.MAX_TOKEN);
        map.put("messages",messages);
        // 设置请求header
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + ChatGptConfig.API_KEY);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(map, header);

        return restTemplate.postForObject(ChatGptConfig.URL, httpEntity, ChatGptResponse.class);
    }

    public ChatGptResponse askQuestion(BotRequest botRequest) {
        return httpPost(botRequest.getMessage());
    }
//    public ChatGptResponse askQuestion(BotRequest botRequest) {
//        List<ChatMessage> messages = new ArrayList<>();  // java version agnostic
//        ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), botRequest.getMessage());
//        messages.add(systemMessage);
//        System.out.println("Bill messages: " + messages);
//        return this.getResponse(
//                this.buildHttpEntity(
//                        new ChatGptRequest(
//                                ChatGptConfig.MODEL,
////                                messages,
//                                botRequest.getMessage(),
//                                ChatGptConfig.MAX_TOKEN)));
////                                ChatGptConfig.N,
////                                ChatGptConfig.LOGIT_BIAS)));
//
//    }
}






