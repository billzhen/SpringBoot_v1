package com.bill.demo.request;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class ProgramRequest implements Serializable {
    private String programString;

    private String className;

}



