package io.github.danielnaczo.multitenancydemo.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private LocalDateTime orderDateTime;
    private Long productCode;
    private String customerId;
}
