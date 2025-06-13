package com.ww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestFuncApplication {
    public static void main(String[] args){
        SpringApplication.run(TestFuncApplication.class);
    }
}


// # 查找占用8081端口的进程ID
// netstat -ano | findstr :8081

// # 假设找到的PID是12345，终止该进程
// taskkill /F /PID 13792
