package tech.escalab.springdeliveries.dto.driver;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class DriverRequestDto {
    @Schema(example = "1234")
    @NotNull(message = "El codigo no puede ser nulo")
    private String code;
    @Schema(example = "Gabriel")
    @NotNull(message = "El nombre no puede ser nulo")
    private String name;
    @Schema(example = "099873162")
    private String cellphone;
    @Schema(example = "gmurugosa@gmail.com")
    @Email(message = "El formato del email no es válido")
    private String email;
    @Schema(example = "true")
    @NotNull(message = "El valor enabled no puede ser nulo")
    private boolean enabled;

}
