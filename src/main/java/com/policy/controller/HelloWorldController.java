package com.policy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class HelloWorldController { 
  @GetMapping("/")
  public String index() {
      System.out.println("HelloWorldController-Hello!!!!!!");
    return "Greetings from Spring Boot!";
  }
 
}
