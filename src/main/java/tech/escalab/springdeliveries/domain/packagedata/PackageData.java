package tech.escalab.springdeliveries.domain.packagedata;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import tech.escalab.springdeliveries.domain.truck.Truck;
import tech.escalab.springdeliveries.domain.packageproducts.PackageProducts;

import java.time.LocalDateTime;
import java.util.*;


@Entity
@Table(name="Packages")
@SQLDelete(sql = "UPDATE Packages SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PackageData {
    @Id
    private UUID uuid = UUID.randomUUID();
    @NotNull
    private String code;
    @NotNull
    private double weight;
    @NotNull
    private LocalDateTime schedule;
    @Enumerated(EnumType.STRING)
    private PackageStatus status = PackageStatus.IN_TRANSIT;
    private boolean isDeleted = Boolean.FALSE;
    private LocalDateTime deletedAt;
    @OneToMany(orphanRemoval = true,fetch = FetchType.EAGER,mappedBy = "packageData", cascade = CascadeType.ALL)
    private List<PackageProducts> packageProductsList = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private Truck truck;

}
