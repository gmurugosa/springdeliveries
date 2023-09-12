package tech.escalab.springdeliveries.domain.packageproducts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import tech.escalab.springdeliveries.domain.packagedata.PackageData;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name="PackageProducts")
@SQLDelete(sql = "UPDATE Package_Products SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PackageProducts {
    @Id
    private UUID uuid = UUID.randomUUID();
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private PackageData packageData;
    @NotNull
    private String code;
    @NotNull
    private Double weight;
    @NotNull
    private String sku;
    @NotNull
    private Integer quantity;
    private boolean isDeleted;
    private LocalDateTime deletedAt;

}
