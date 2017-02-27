package com.reverseproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ReverseProxyServer {

  public static void main(String[] args) {
    SpringApplication.run(ReverseProxyServer.class, args);
  }

}
