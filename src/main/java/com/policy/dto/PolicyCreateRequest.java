package com.policy.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record PolicyCreateRequest(
 @NotBlank String policyNumber,
 @NotBlank String insuredName,
 @NotBlank String productName,
 @NotNull @Positive BigDecimal premium,
 @NotNull LocalDate startDate
) {}
