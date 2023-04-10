package com.bill.demo.request;

import java.util.ArrayList;

public class RequestParams {
    private ArrayList<String> names;

    private String url;

    public ArrayList getNames() {
        return names;
    }

    public void setNames(ArrayList names) {
        this.names = names;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
