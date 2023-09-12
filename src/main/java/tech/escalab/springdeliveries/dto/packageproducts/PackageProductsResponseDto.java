package tech.escalab.springdeliveries.dto.packageproducts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
@Getter
@Setter
@ToString
public class PackageProductsResponseDto {
    private UUID UUID;
    private String code;
    private Double weight;
    private String sku;
    private Integer quantity;
}
