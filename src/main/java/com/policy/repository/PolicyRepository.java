package com.policy.repository;

import com.policy.dao.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PolicyRepository extends JpaRepository<Policy,String> {
 boolean existsByPolicyNumber(String policyNumber);
 Optional<Policy> findByPolicyNumber(String policyNumber);
}
