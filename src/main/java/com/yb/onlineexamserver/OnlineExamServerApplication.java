package com.yb.onlineexamserver;

import com.yb.onlineexamserver.utils.FileUploadUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class OnlineExamServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineExamServerApplication.class, args);
    }

}
