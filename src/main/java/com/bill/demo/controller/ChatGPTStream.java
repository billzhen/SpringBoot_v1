package com.bill.demo.controller;

import com.bill.demo.config.ChatGptConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ChatGPTStream {
  private final ReadWriteLock lock = new ReentrantReadWriteLock();
  private ArrayList message;


  public void ChatGPTStream () {}
  public ChatGPTStream (ArrayList message) {
    this.message = message;
  }
  public ResponseEntity<StreamingResponseBody> start() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    headers.set("Transfer-Encoding", "chunked");
    System.out.println("Bill insde ResponseEntity.");
    StreamingResponseBody stream = out -> {
      HttpURLConnection connection = null;
      BufferedReader reader = null;
      try {
        URL getUrl = new URL(ChatGptConfig.URL);
        connection = (HttpURLConnection) getUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + ChatGptConfig.API_KEY);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("model", ChatGptConfig.MODEL);
        map.put("max_tokens", ChatGptConfig.MAX_TOKEN);
        map.put("messages", message);
        map.put("stream", true);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(map);
        byte[] jsonBytes = jsonStr.getBytes("UTF-8");
        connection.getOutputStream().write(jsonBytes);

        int responseCode = connection.getResponseCode();
        System.out.println("Bill responseCode： " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
          reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          String line;
          while ((line = reader.readLine()) != null) {
            out.write(line.getBytes());
            out.flush();
          }
        }
      } catch (Exception e) {
        System.out.println("Exception e" + e);
      }
      out.close();
    };
    return new ResponseEntity<>(stream, headers, HttpStatus.OK);
  }

}
