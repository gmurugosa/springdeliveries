package tech.escalab.springdeliveries.mapper.packagedata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.springdeliveries.domain.packagedata.PackageData;
import tech.escalab.springdeliveries.domain.packageproducts.PackageProducts;
import tech.escalab.springdeliveries.dto.packagedata.PackageDataRequestDto;
import tech.escalab.springdeliveries.dto.packagedata.PackageDataResponseDto;
import tech.escalab.springdeliveries.dto.packageproducts.PackageProductsResponseDto;
import tech.escalab.springdeliveries.mapper.packageproduct.PackageProductsMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PackageDataMapper {

    private final PackageProductsMapper packageProductsMapper;
    public PackageData toPackageData(PackageDataRequestDto packageDataDto){
        if (packageDataDto == null) {
            return null;
        }

        var packageData = new PackageData();

        if (Objects.nonNull(packageDataDto.getCode())) {
            packageData.setCode(packageDataDto.getCode());
        }

        if (Objects.nonNull(packageDataDto.getWeight())) {
            packageData.setWeight(packageDataDto.getWeight());
        }

        if (Objects.nonNull(packageDataDto.getSchedule())) {
            packageData.setSchedule(packageDataDto.getSchedule());
        }

        if (Objects.nonNull(packageDataDto.getStatus())) {
            packageData.setStatus(packageDataDto.getStatus());
        }

        if (Objects.nonNull(packageDataDto.getLista())) {

            List<PackageProducts> listPackageData = packageDataDto.getLista().stream().map(pd -> {
                PackageProducts packageProduct = packageProductsMapper.toPackageProducts(pd);
                packageProduct.setPackageData(packageData);
                return packageProduct;
            }).collect(Collectors.toList());

            packageData.setPackageProductsList(listPackageData);
        }

        return packageData;
    }

    public PackageDataResponseDto toResponseDto(PackageData packageData){

        if (packageData == null) {
            return null;
        }

        var packageDataResponseDto = new PackageDataResponseDto();

        if (Objects.nonNull(packageData.getUuid())) {
            packageDataResponseDto.setUUID(packageData.getUuid());
        }
        if (Objects.nonNull(packageData.getCode())) {
            packageDataResponseDto.setCode(packageData.getCode());
        }

        if (Objects.nonNull(packageData.getWeight())) {
            packageDataResponseDto.setWeight(packageData.getWeight());
        }

        if (Objects.nonNull(packageData.getSchedule())) {
            packageDataResponseDto.setSchedule(packageData.getSchedule());
        }

        if (Objects.nonNull(packageData.getStatus())) {
            packageDataResponseDto.setStatus(packageData.getStatus());
        }

        if (Objects.nonNull(packageData.getPackageProductsList())) {
            List<PackageProductsResponseDto> listPackageDataResponse = new ArrayList<>();
            packageData.getPackageProductsList().stream().forEach(pd -> listPackageDataResponse.add(packageProductsMapper.toResponseDto(pd)));
            packageDataResponseDto.setPackageProductsList(listPackageDataResponse);
        }

        return packageDataResponseDto;
    }

    public void update(PackageData packageDataSource, PackageData packageDataTarget){

        if (Objects.nonNull(packageDataSource.getUuid())) {
            packageDataTarget.setUuid(packageDataSource.getUuid());
        }

        if (Objects.nonNull(packageDataSource.getCode())) {
            packageDataTarget.setCode(packageDataSource.getCode());
        }

        if (Objects.nonNull(packageDataSource.getWeight())) {
            packageDataTarget.setWeight(packageDataSource.getWeight());
        }

        if (Objects.nonNull(packageDataSource.getSchedule())) {
            packageDataTarget.setSchedule(packageDataSource.getSchedule());
        }

        if (Objects.nonNull(packageDataSource.getStatus())) {
            packageDataTarget.setStatus(packageDataSource.getStatus());
        }

    }

}
