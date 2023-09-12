package tech.escalab.springdeliveries.dto.truck;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.escalab.springdeliveries.domain.driver.Driver;
import tech.escalab.springdeliveries.dto.driver.DriverRequestDto;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class TruckRequestDto {
    @Schema(example = "1234")
    @NotNull(message = "El codigo no puede ser nulo")
    private String code;
    @Schema(example = "true")
    @NotNull(message = "El valor enabled no puede ser nulo")
    private boolean enabled;
    private DriverRequestDto driver;

}
