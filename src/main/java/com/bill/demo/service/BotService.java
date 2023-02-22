package com.bill.demo.service;

import com.bill.demo.request.BotRequest;
import com.bill.demo.response.ChatGptResponse;

public interface BotService {

    ChatGptResponse askQuestion(BotRequest botRequest);
}
