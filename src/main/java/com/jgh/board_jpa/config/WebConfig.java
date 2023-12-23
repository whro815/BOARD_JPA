package com.jgh.board_jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private String resourcePath = "/upload/**";                 //view 에서 접근할 경로
    private String savePath = "file:///D:/jgh/BOARD_JPA_FILE/"; // 실제 파일 저장 경로
    /* file:///Users/사용자이름/BOARD_JPA_FILE/ */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcePath)
                .addResourceLocations(savePath);
    }
}
