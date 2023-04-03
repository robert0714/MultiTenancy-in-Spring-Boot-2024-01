package io.github.danielnaczo.multitenancydemo.model.tenant;

import io.github.danielnaczo.multitenancydemo.model.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_gen", sequenceName = "customer_seq")
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UQ__customer__customer_id", columnNames = {"customerId"})
    }
)
public class Customer extends Base {

    private String customerId;
    private String firstName;
    private String lastName;
    private String address;
}
