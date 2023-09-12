package tech.escalab.springdeliveries.domain.truck;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import tech.escalab.springdeliveries.domain.driver.Driver;
import tech.escalab.springdeliveries.domain.packagedata.PackageData;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name="Trucks")
@SQLDelete(sql = "UPDATE Trucks SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Truck {
    @Id
    private UUID uuid = UUID.randomUUID();
    @NotNull
    private String code;
    @NotNull
    private boolean enabled;
    private boolean isDeleted;
    private LocalDateTime deletedAt;
    @OneToMany(mappedBy = "truck")
    private Set<PackageData> packagesList = new HashSet<>();
    @OneToOne(fetch = FetchType.LAZY)
    private Driver driver;

}
