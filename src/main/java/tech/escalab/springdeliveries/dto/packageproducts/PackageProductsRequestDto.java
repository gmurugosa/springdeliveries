package tech.escalab.springdeliveries.dto.packageproducts;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class PackageProductsRequestDto {
    @Schema(example = "1234")
    @NotNull(message = "El codigo no puede ser nulo")
    private String code;
    @Schema(example = "180.50")
    @NotNull(message = "El peso no puede ser nulo")
    private Double weight;
    @Schema(example = "A1E2B3")
    @NotNull(message = "El sku no puede ser nulo")
    private String sku;
    @Schema(example = "20")
    @NotNull(message = "La cantidad no puede ser nula")
    private Integer quantity;
}
