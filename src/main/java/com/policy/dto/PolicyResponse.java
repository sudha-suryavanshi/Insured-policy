package com.policy.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PolicyResponse(
 String id,
 String policyNumber,
 String insuredName,
 String productName,
 BigDecimal premium,
 LocalDate startDate,
 String status
) {}
