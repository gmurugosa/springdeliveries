package tech.escalab.springdeliveries.dto.driver;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.escalab.springdeliveries.domain.packageproducts.PackageProducts;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
public class DriverResponseDto {
    private UUID UUID;
    private String code;
    private String name;
    private String cellphone;
    private String email;
    private boolean enabled;
    private Set<PackageProducts> packageProductsList;
}
