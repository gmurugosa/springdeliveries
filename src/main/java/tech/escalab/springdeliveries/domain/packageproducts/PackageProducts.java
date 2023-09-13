package tech.escalab.springdeliveries.domain.packageproducts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
    @NotNull(message = "{packageProducts.code.not.null}")
    @NotEmpty(message = "{packageProducts.code.not.empty}")
    private String code;
    @NotNull(message = "{packageProducts.weight.not.null}")
    private Double weight;
    @NotNull(message = "{packageProducts.sku.not.null}")
    @NotEmpty(message = "{packageProducts.sku.not.empty}")
    private String sku;
    @NotNull(message = "{packageProducts.quantity.not.null}")
    @Min(value = 1, message = "{packageProducts.quantity.invalid.value}")
    private Integer quantity;
    private boolean isDeleted;
    private LocalDateTime deletedAt;

}
