package tech.escalab.springdeliveries.dto.packagedata;

import lombok.*;
import tech.escalab.springdeliveries.domain.packagedata.PackageStatus;
import tech.escalab.springdeliveries.dto.packageproducts.PackageProductsRequestDto;
import tech.escalab.springdeliveries.dto.packageproducts.PackageProductsResponseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
public class PackageDataResponseDto {
    private UUID UUID;
    private String code;
    private double weight;
    private LocalDateTime schedule;
    private PackageStatus status;
    private List<PackageProductsResponseDto> packageProductsList;
}
