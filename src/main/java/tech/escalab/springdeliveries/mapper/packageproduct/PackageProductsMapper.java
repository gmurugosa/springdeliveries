package tech.escalab.springdeliveries.mapper.packageproduct;

import org.springframework.stereotype.Component;
import tech.escalab.springdeliveries.domain.packageproducts.PackageProducts;
import tech.escalab.springdeliveries.dto.packageproducts.PackageProductsRequestDto;
import tech.escalab.springdeliveries.dto.packageproducts.PackageProductsResponseDto;

import java.util.Objects;

@Component
public class PackageProductsMapper {

    public PackageProducts toPackageProducts(PackageProductsRequestDto packageProductsDto){
        if (packageProductsDto == null) {
            return null;
        }

        var packageProducts = new PackageProducts();

        if (Objects.nonNull(packageProductsDto.getCode())) {
            packageProducts.setCode(packageProductsDto.getCode());
        }

        if (Objects.nonNull(packageProductsDto.getWeight())) {
            packageProducts.setWeight(packageProductsDto.getWeight());
        }

        if (Objects.nonNull(packageProductsDto.getSku())) {
            packageProducts.setSku(packageProductsDto.getSku());
        }

        if (Objects.nonNull(packageProductsDto.getQuantity())) {
            packageProducts.setQuantity(packageProductsDto.getQuantity());
        }

        return packageProducts;
    }

    public PackageProductsResponseDto toResponseDto(PackageProducts packageProducts){

        if (packageProducts == null) {
            return null;
        }

        var packageProductsResponseDto = new PackageProductsResponseDto();

        if (Objects.nonNull(packageProducts.getUuid())) {
            packageProductsResponseDto.setUUID(packageProducts.getUuid());
        }
        if (Objects.nonNull(packageProducts.getCode())) {
            packageProductsResponseDto.setCode(packageProducts.getCode());
        }

        if (Objects.nonNull(packageProducts.getWeight())) {
            packageProductsResponseDto.setWeight(packageProducts.getWeight());
        }

        if (Objects.nonNull(packageProducts.getSku())) {
            packageProductsResponseDto.setSku(packageProducts.getSku());
        }

        if (Objects.nonNull(packageProducts.getQuantity())) {
            packageProductsResponseDto.setQuantity(packageProducts.getQuantity());
        }

        return packageProductsResponseDto;
    }

    public void update(PackageProducts packageProductsDataSource, PackageProducts packageProductsDataTarget){

        if (Objects.nonNull(packageProductsDataSource.getUuid())) {
            packageProductsDataTarget.setUuid(packageProductsDataSource.getUuid());
        }
        if (Objects.nonNull(packageProductsDataSource.getCode())) {
            packageProductsDataTarget.setCode(packageProductsDataSource.getCode());
        }

        if (Objects.nonNull(packageProductsDataSource.getWeight())) {
            packageProductsDataTarget.setWeight(packageProductsDataSource.getWeight());
        }

        if (Objects.nonNull(packageProductsDataSource.getSku())) {
            packageProductsDataTarget.setSku(packageProductsDataSource.getSku());
        }

        if (Objects.nonNull(packageProductsDataSource.getQuantity())) {
            packageProductsDataTarget.setQuantity(packageProductsDataSource.getQuantity());
        }

    }
}
