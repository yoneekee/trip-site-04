package com.bb.voyage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Value("${file.path}")
  private String uploadPath;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //WebMvcConfigurer.super.addResourceHandlers(registry);
    registry
      .addResourceHandler("/upload/**")
      .addResourceLocations("file:///" + uploadPath);
  }
}
