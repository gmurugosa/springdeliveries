package tech.escalab.springdeliveries.domain.driver;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    @NotNull
    private String code;
    @NotNull
    private String name;
    private String cellphone;
    @Email
    private String email;
    @NotNull
    private boolean enabled;
    private boolean isDeleted;
    private LocalDateTime deletedAt;
    @OneToOne(fetch = FetchType.LAZY)
    private Truck truck;

}
