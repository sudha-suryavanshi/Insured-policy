package com.policy.dao;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Policy {

 @Id
 @GeneratedValue(strategy = GenerationType.UUID)
 private String id;

 @Column(nullable=false, unique=true)
 private String policyNumber;

 @Column(nullable=false)
 private String insuredName;

 @Column(nullable=false)
 private String productName;

 @Column(nullable=false)
 private BigDecimal premium;

 @Column(nullable=false)
 private LocalDate startDate;

 @Column(nullable=false)
 private String status;
}
