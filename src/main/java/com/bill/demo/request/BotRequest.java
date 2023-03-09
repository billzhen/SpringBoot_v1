package com.bill.demo.request;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class BotRequest implements Serializable {
    private ArrayList message;

}



