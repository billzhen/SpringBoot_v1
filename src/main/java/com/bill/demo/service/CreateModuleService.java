package com.bill.demo.service;

import com.bill.demo.request.BotRequest;
import com.bill.demo.request.ProgramRequest;
import com.bill.demo.response.ChatGptResponse;

public interface CreateModuleService {

    void createModule(ProgramRequest programRequest);
}
