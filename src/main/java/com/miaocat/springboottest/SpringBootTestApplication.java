package com.miaocat.springboottest;

import com.miaocat.springboottest.config.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class SpringBootTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebConfiguration.class, args);
  }

}
