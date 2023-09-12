package tech.escalab.springdeliveries.service.packagedata.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.escalab.springdeliveries.dao.packagedata.PackageDataRepositoryJpa;
import tech.escalab.springdeliveries.dao.packageproducts.PackageProductsRepositoryJpa;
import tech.escalab.springdeliveries.domain.packagedata.PackageData;
import tech.escalab.springdeliveries.domain.packagedata.PackageStatus;
import tech.escalab.springdeliveries.domain.packageproducts.PackageProducts;
import tech.escalab.springdeliveries.dto.packagedata.PackageDataRequestDto;
import tech.escalab.springdeliveries.dto.packagedata.PackageDataResponseDto;
import tech.escalab.springdeliveries.mapper.packagedata.PackageDataMapper;
import tech.escalab.springdeliveries.service.packagedata.PackageDataService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class PackageDataServiceImpl implements PackageDataService {

    private final PackageDataRepositoryJpa packageDataRepositoryJpa;
    private final PackageProductsRepositoryJpa packageProductsRepositoryJpa;
    private PackageDataMapper packageDataMapper;
    @Override
    public List<PackageDataResponseDto> findAll() {
        return packageDataRepositoryJpa.findAll().stream().
                map(packageData -> packageDataMapper.toResponseDto(packageData) ).collect(Collectors.toList());
    }

    @Override
    public PackageData findByUuid(UUID uuid) {
        return packageDataRepositoryJpa.findById(uuid).get();
    }

    @Override
    public PackageDataResponseDto save(PackageDataRequestDto packageDataDto) {
        var packageData = packageDataMapper.toPackageData(packageDataDto);
        packageDataRepositoryJpa.save(packageData);
        return packageDataMapper.toResponseDto(packageData);
    }

    @Override
    public PackageDataResponseDto udpate(UUID uuid, PackageDataRequestDto packageDataDtoDto) {
        var packageDataSource = packageDataMapper.toPackageData(packageDataDtoDto);
        var packageDataTarget = findByUuid(uuid);
        packageDataSource.setUuid(uuid);
        packageDataMapper.update(packageDataSource,packageDataTarget);
        packageDataRepositoryJpa.save(packageDataTarget);
        return packageDataMapper.toResponseDto(packageDataTarget);
    }

    @Override
    public PackageDataResponseDto udpatePackageStatus(UUID uuid, PackageStatus status) {
        var packageData = findByUuid(uuid);
        packageData.setStatus(status);
        packageDataRepositoryJpa.save(packageData);
        return packageDataMapper.toResponseDto(packageData);
    }

    @Override
    public PackageDataResponseDto delete(UUID uuid) {
        var driverDeleted = findByUuid(uuid);
        packageDataRepositoryJpa.deleteById(uuid);
        return packageDataMapper.toResponseDto(driverDeleted);
    }
    @Override
    @Transactional
    public PackageDataResponseDto deletePackageProductsList(UUID uuid, List<String> packageProductsDeleteList) throws Exception {

        PackageData packageData = findByUuid(uuid);

        if(!packageData.getStatus().equals(PackageStatus.LOADED)){
            throw new Exception("Solo es posible eliminar productos de un paquete en estado LOADED, STATUS= "+packageData.getStatus());
        }

        List<PackageProducts> listPackageProducts = packageData.getPackageProductsList();

        List<PackageProducts> listPackageProductsToRemove = listPackageProducts.stream()
                .filter(sku -> packageProductsDeleteList.stream()
                        .anyMatch(targetSku -> sku.getSku().equals(targetSku)))
                .collect(Collectors.toList());

        listPackageProducts.removeAll(listPackageProductsToRemove);

        packageDataRepositoryJpa.save(packageData);

        return packageDataMapper.toResponseDto(packageData);

    };
}
