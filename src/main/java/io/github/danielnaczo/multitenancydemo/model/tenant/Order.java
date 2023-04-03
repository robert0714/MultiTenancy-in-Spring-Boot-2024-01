package io.github.danielnaczo.multitenancydemo.model.tenant;

import io.github.danielnaczo.multitenancydemo.model.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Ordering")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_gen", sequenceName = "ordering_seq")
public class Order extends Base {
    private LocalDateTime orderDateTime;
    private Long productCode;
    @OneToOne
    @NotNull
    @JoinColumn(foreignKey = @ForeignKey(name = "FK__order__customer"))
    private Customer customer;
}
