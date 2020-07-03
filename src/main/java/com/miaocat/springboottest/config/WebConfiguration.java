package com.miaocat.springboottest.config;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.servlet.function.ServerResponse.ok;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * <p>
 *
 * @author yulong.yang, yulong.yang@ucarinc.com
 * @version 1.0
 * @date 2020/7/3
 **/
@EnableAutoConfiguration
public class WebConfiguration {

  @Bean
  public RouterFunction<ServerResponse> helloWorld() {
    return route(GET("/hello-world"), new HandlerFunction<ServerResponse>() {
      @Override
      public ServerResponse handle(ServerRequest request) throws Exception {
        return ok().body("Hello, world");
      }
    });
  }

  @Bean
  public ApplicationRunner runner(BeanFactory beanFactory) {
    return args -> {
      System.out.println("当前 helloWorld Bean 实现类为："  + beanFactory.getBean("helloWorld").getClass().getName());
      System.out.println("当前 WebConfiguration Bean 实现类为：" + beanFactory.getBean(WebConfiguration.class).getClass().getName());
    };
  }


}
