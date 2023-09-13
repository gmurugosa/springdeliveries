package tech.escalab.springdeliveries.domain.driver;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import jakarta.validation.constraints.NotNull;
import tech.escalab.springdeliveries.domain.truck.Truck;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name="Drivers")
@SQLDelete(sql = "UPDATE Drivers SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Driver {

    @Id
    private UUID uuid = UUID.randomUUID();
    @NotNull(message = "{driver.code.not.null}")
    @NotEmpty(message = "{driver.code.not.empty}")
    private String code;
    @NotNull(message = "{driver.name.not.null}")
    @NotEmpty(message = "{driver.name.not.empty}")
    private String name;
    @NotNull(message = "{driver.cellphone.not.null}")
    @NotEmpty(message = "{driver.cellphone.not.empty}")
    private String cellphone;
    @Email(message = "{driver.email.not.valid}")
    private String email;
    @NotNull(message = "{driver.enabled.not.null}")
    private boolean enabled;
    private boolean isDeleted;
    private LocalDateTime deletedAt;
    @OneToOne(fetch = FetchType.LAZY)
    private Truck truck;

}
