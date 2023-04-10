package com.bill.demo.service;

import com.bill.demo.request.DataClean;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public ChatGptResponse httpPost(ArrayList messages){
        RestTemplate restTemplate=new RestTemplate();

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("model", ChatGptConfig.MODEL);
        map.put("max_tokens", ChatGptConfig.MAX_TOKEN);
        map.put("messages", messages);
        // 设置请求header
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + ChatGptConfig.API_KEY);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(map, header);

        return restTemplate.postForObject(ChatGptConfig.URL, httpEntity, ChatGptResponse.class);
    }


//    public ChatGptResponse httpPost(ArrayList message){
//        RestTemplate restTemplate=new RestTemplate();
//        // 设置请求body
//        List<ChatMessage> messages = new ArrayList<>();  // java version agnostic
//        ChatMessage systemMessage = new ChatMessage(ChatMessageRole.ASSISTANT.value(), message);
//        messages.add(systemMessage);
//        Map<String, Object> map = new LinkedHashMap<>();
//        map.put("model", ChatGptConfig.MODEL);
//        map.put("max_tokens", ChatGptConfig.MAX_TOKEN);
//        map.put("messages",messages);
//        // 设置请求header
//        HttpHeaders header = new HttpHeaders();
//        header.setContentType(MediaType.APPLICATION_JSON);
//        header.add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + ChatGptConfig.API_KEY);
//        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(map, header);
//
//        return restTemplate.postForObject(ChatGptConfig.URL, httpEntity, ChatGptResponse.class);
//    }

    public void httpConnection() throws IOException {
        String apiKey = "YOUR_API_KEY"; // 替换为您的API key
        String url = "API_URL"; // 替换为ChatGPT API URL
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Authorization", "Bearer " + apiKey);

        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // 输出API返回的内容
        System.out.println(response.toString());
    }

    public ChatGptResponse askQuestion(BotRequest botRequest) {
        ArrayList messages = botRequest.getMessage();
        int lastIndex = messages.size() - 1;
        String lastElementStr = messages.get(lastIndex).toString();

        Pattern pattern = Pattern.compile("(?i)\\b((?:(http|https|ftp)://|www\\.)\\S+)\\b");
        Matcher matcher = pattern.matcher(lastElementStr);
        String url = "";
        String requestText = "";
        while (matcher.find()) {
            url = matcher.group(1);
        }

        // 判断是否存在链接
        if (url.trim().isEmpty()) {
            // 直接访问 chatgpt
            System.out.println("Bill url.trim().isEmpty()  is true.");
            return httpPost(botRequest.getMessage());
        } else {
            // 爬取数据
            DataClean dataClean = new DataClean(url);
            requestText = dataClean.getRequestText();
            // 设置请求参数
            ChatMessage message = new ChatMessage();
            message.setRole("user");
            message.setContent(requestText);
            messages.set(lastIndex, message);
            // 拿到chatgpt的响应值设置到reponse里面去
            ChatGptResponse chatGptResponse = httpPost(messages);
            chatGptResponse.getChoices().get(0).getMessage().setType("chatgpt-url");
            chatGptResponse.getChoices().get(0).getMessage().setQuestion(requestText);
            return chatGptResponse;
        }

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






