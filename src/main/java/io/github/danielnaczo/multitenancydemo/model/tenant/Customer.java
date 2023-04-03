package io.github.danielnaczo.multitenancydemo.model.tenant;

import io.github.danielnaczo.multitenancydemo.model.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_gen", sequenceName = "customer_seq")
public class Customer extends Base {

    private String name;
    private String firstName;
    private String lastName;
    private String address;
}
