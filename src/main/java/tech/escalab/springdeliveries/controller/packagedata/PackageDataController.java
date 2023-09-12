package tech.escalab.springdeliveries.controller.packagedata;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.escalab.springdeliveries.domain.packagedata.PackageData;
import tech.escalab.springdeliveries.domain.packagedata.PackageStatus;
import tech.escalab.springdeliveries.dto.packagedata.PackageDataRequestDto;
import tech.escalab.springdeliveries.dto.packagedata.PackageDataResponseDto;
import tech.escalab.springdeliveries.service.packagedata.PackageDataService;
import tech.escalab.springdeliveries.swagger.PackageDataSwagger;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/PackageData")
public class PackageDataController implements PackageDataSwagger {

    private final PackageDataService packageDataService;

    @Override
    @GetMapping
    public List<PackageDataResponseDto> findAll() {

        return packageDataService.findAll();
    }
    @Override
    @PostMapping("")
    public PackageDataResponseDto save(@Valid @RequestBody PackageDataRequestDto packageData){

        return packageDataService.save(packageData);

    }

    @Override
    @PutMapping("/{uuid}")
    public void update(
            @PathVariable UUID uuid,
            @Valid @RequestBody PackageDataRequestDto packageData
    ) {
        packageDataService.udpate(uuid,packageData);
    }

    @Override
    @PutMapping("/UpdatePackageStatus/{uuid}")
    public PackageDataResponseDto udpatePackageStatus(@PathVariable UUID uuid,  @RequestBody PackageStatus status) {
        return packageDataService.udpatePackageStatus(uuid,status);
    }

    @Override
    @DeleteMapping("/{uuid}")
    public PackageDataResponseDto delete(
            @PathVariable UUID uuid
    ) {
        return packageDataService.delete(uuid);
    }

    @Override
    @DeleteMapping("/DeletePackageProductsList/{uuid}")
    public PackageDataResponseDto deletePackageProductsList(
            @PathVariable UUID uuid, @RequestBody List<String> packageProductsDeleteList) throws Exception {

        return packageDataService.deletePackageProductsList(uuid,packageProductsDeleteList);

    }
}
