package io.github.danielnaczo.multitenancydemo.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {
    private String customerCode;
    private String firstName;
    private String lastName;
    private String address;
}
