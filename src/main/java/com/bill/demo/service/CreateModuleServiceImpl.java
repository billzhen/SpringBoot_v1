package com.bill.demo.service;

import com.bill.demo.config.ChatGptConfig;
import com.bill.demo.request.BotRequest;
import com.bill.demo.request.ChatGptRequest;
import com.bill.demo.request.DataClean;
import com.bill.demo.request.ProgramRequest;
import com.bill.demo.response.ChatGptResponse;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CreateModuleServiceImpl implements CreateModuleService {

    @Override
    public void createModule(ProgramRequest programRequest) {
        String fileName = "C:\\DemoProgram\\"+programRequest.getClassName();
        String className = programRequest.getClassName();
        String fileContent = programRequest.getProgramString();
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(fileContent);
            fileWriter.close();
            System.out.println("Java file generated successfully.");
            compileClass(fileName, className);
        } catch (IOException e) {
            System.out.println("An error occurred while generating Java file.");
            e.printStackTrace();
        }
    }
    private void compileClass(String javaName, String className){
        // 获取Java编译器实例
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 调用编译器编译Java文件
        int compilationResult = compiler.run(null, null, null, javaName);
        // 检查编译结果
        if (compilationResult == 0) {
            System.out.println("Compilation is successful");
        } else {
            System.out.println("Compilation Failed");
        }
        exuecteClass(className);
    }
    private void exuecteClass(String className){
        try {
            String classNameString = className.substring(0,className.length()-5);
            Process p = Runtime.getRuntime().exec("cmd /c start cmd.exe /k java -cp C:\\DemoProgram "+ classNameString);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






