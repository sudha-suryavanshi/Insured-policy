package com.policy.service;

import com.policy.dao.Policy;
import com.policy.dto.*;
import com.policy.repository.PolicyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class PolicyService {

 private final PolicyRepository repo;

 public PolicyService(PolicyRepository repo){
   this.repo = repo;
 }

 public PolicyResponse create(PolicyCreateRequest req){
   if(repo.existsByPolicyNumber(req.policyNumber()))
     throw new ResponseStatusException(HttpStatus.CONFLICT,"Policy exists");

   Policy p = repo.save(
     Policy.builder()
       .policyNumber(req.policyNumber())
       .insuredName(req.insuredName())
       .productName(req.productName())
       .premium(req.premium())
       .startDate(req.startDate())
       .status("ACTIVE")
       .build()
   );

   return map(p);
 }

 public PolicyResponse get(String id){
   return repo.findById(id).map(this::map)
     .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found"));
 }

 public List<PolicyResponse> list(){
   return repo.findAll().stream().map(this::map).toList();
 }

 public PolicyResponse cancel(String id){
   Policy p = repo.findById(id)
     .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found"));
   p.setStatus("CANCELLED");
   return map(repo.save(p));
 }

 private PolicyResponse map(Policy p){
   return new PolicyResponse(
     p.getId(),
     p.getPolicyNumber(),
     p.getInsuredName(),
     p.getProductName(),
     p.getPremium(),
     p.getStartDate(),
     p.getStatus()
   );
 }
}
