package tech.escalab.springdeliveries.service.packagedata;

import tech.escalab.springdeliveries.domain.packagedata.PackageData;
import tech.escalab.springdeliveries.domain.packagedata.PackageStatus;
import tech.escalab.springdeliveries.dto.packagedata.PackageDataRequestDto;
import tech.escalab.springdeliveries.dto.packagedata.PackageDataResponseDto;

import java.util.List;
import java.util.UUID;

public interface PackageDataService {

    List<PackageDataResponseDto> findAll();

    PackageData findByUuid(UUID uuid);

    PackageDataResponseDto save(PackageDataRequestDto driver);

    PackageDataResponseDto udpate(UUID uuid, PackageDataRequestDto driverDto);

    PackageDataResponseDto delete(UUID uuid);

    PackageDataResponseDto udpatePackageStatus(UUID uuid, PackageStatus status);

    PackageDataResponseDto deletePackageProductsList(UUID uuid, List<String> packageProductsDeleteList) throws Exception;
}
