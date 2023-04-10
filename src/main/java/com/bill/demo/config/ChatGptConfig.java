package com.bill.demo.config;

import java.util.HashMap;
public class ChatGptConfig {

    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String API_KEY = "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";
    public static final String MODEL = "gpt-3.5-turbo-0301";
//    public static final String MODEL = "text-davinci-003";
    public static final Integer MAX_TOKEN = 2048;
    public static final Double TEMPERATURE = 0.0;
    public static final Double TOP_P = 1.0;

//    public static final Integer N = 5;

//    public static final HashMap LOGIT_BIAS = new HashMap();
    public static final String MEDIA_TYPE = "application/json";
    public static final String URL = "https://api.openai.com/v1/chat/completions";
//    public static final String URL = "https://api.openai.com/v1/completions";
}
