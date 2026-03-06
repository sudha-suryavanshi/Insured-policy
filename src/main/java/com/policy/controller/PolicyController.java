package com.policy.controller;

import com.policy.dto.*;
import com.policy.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

 private final PolicyService service;

 public PolicyController(PolicyService service){
   this.service = service;
 }

 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
 public PolicyResponse create(@Valid @RequestBody PolicyCreateRequest req){
   return service.create(req);
 }

 @GetMapping
 public List<PolicyResponse> list(){
   return service.list();
 }

 @GetMapping("/{id}")
 public PolicyResponse get(@PathVariable String id){
   return service.get(id);
 }

 @PostMapping("/{id}/cancel")
 public PolicyResponse cancel(@PathVariable String id){
   return service.cancel(id);
 }
}
