package tech.escalab.springdeliveries.dto.packagedata;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.escalab.springdeliveries.domain.packagedata.PackageStatus;
import tech.escalab.springdeliveries.domain.packageproducts.PackageProducts;
import tech.escalab.springdeliveries.dto.packageproducts.PackageProductsRequestDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class PackageDataRequestDto {
    @Schema(example = "1234")
    @NotNull(message = "El codigo no puede ser nulo")
    private String code;
    @Schema(example = "180.50")
    @NotNull(message = "El peso no puede ser nulo")
    private Double weight;
    @Schema(example = "11/2/1984")
    @NotNull(message = "La fecha no puede ser nula")
    private LocalDateTime schedule;
    @Schema(example = "IN_TRANSIT")
    @NotNull(message = "El estado no puede ser nulo")
    private PackageStatus status;
    private List<PackageProductsRequestDto> lista;
}
