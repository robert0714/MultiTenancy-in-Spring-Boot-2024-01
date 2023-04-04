package io.github.danielnaczo.multitenancydemo.model.shared;

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
@SequenceGenerator(name = "base_gen", sequenceName = "product_seq")
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UQ__product__code", columnNames = {"code"})
    }
)
public class Product extends Base {
    private String name;
    private String code;
}
