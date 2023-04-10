package com.bill.demo.request;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DataClean {
    private String requestText = new String(); // 最终得出的文本
    private static String[] clearArr = {" ", "为什么", "连接", "种子", "\\s", "，", "。", "！", "？", "；", "：", "（", "）",  "}"}; // 所有提出的标点符号
    private static int contentMax = 500; // 文章的最大值
    private ArrayList<String> grade1 = new ArrayList<>();; // 最重要的文本
    private ArrayList<String> grade2 = new ArrayList<>();;
    private ArrayList<String> grade3 = new ArrayList<>();;
    private ArrayList<String> grade4 = new ArrayList<>();;
    private ArrayList<String> grade5 = new ArrayList<>();; // 最次要的文本
    private int minContentLenght1 = 80;   // 当超过文章最大值的时候
    private int minContentLenght2 = 60;   // 当超过文章最大值的时候
    private int minContentLenght3 = 40;   // 当超过文章最大值的时候
    private int minContentLenght4 = 20;   // 当超过文章最大值的时候
    private int minContentLenght5 = 10;   // 当超过文章最大值的时候

    public DataClean(String url) {
        url = URLDecoder.decode(url, StandardCharsets.UTF_8);
        try {
            Connection mozilla = Jsoup.connect(url).userAgent("Mozilla");
            Document document = mozilla.get();
            Elements elements = document.getElementsByClass("news_container");
            String responseText = "我在括号当中给了你一些短文咨询，请你学习一下。(";
            for (Element ele : elements) {
                // 在此处进行遍历处理
                String title = ele.getElementsByClass("news_title").get(0).text();
                String desc = ele.getElementsByClass("news_desc").get(0).text();
                responseText = responseText + "title:" + title + "。 description:" + desc + ";\n";
            }
            responseText = responseText + ")";
            this.requestText = responseText;
        } catch (IOException e) {
            System.out.println("error");
            throw new RuntimeException(e);
        }
    }



    public String getRequestText() {
        return this.requestText;
    }
}
