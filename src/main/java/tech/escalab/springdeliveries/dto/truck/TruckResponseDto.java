package tech.escalab.springdeliveries.dto.truck;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.escalab.springdeliveries.domain.driver.Driver;
import tech.escalab.springdeliveries.dto.driver.DriverResponseDto;

import java.util.UUID;
@Getter
@Setter
@ToString
public class TruckResponseDto {
    private UUID UUID;
    private String code;
    private boolean enabled;
    private DriverResponseDto driver;

}
