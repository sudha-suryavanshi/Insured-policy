package com.policy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class PolicyController { 
  @GetMapping("/")
  public String index() {
      System.out.println("PolicyController!!!!");
    return "Greetings from Spring Boot!";
  }
 
}
