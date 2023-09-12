package tech.escalab.springdeliveries.mapper.driver;

import org.springframework.stereotype.Component;
import tech.escalab.springdeliveries.domain.driver.Driver;
import tech.escalab.springdeliveries.dto.driver.DriverRequestDto;
import tech.escalab.springdeliveries.dto.driver.DriverResponseDto;

import java.util.Objects;

@Component
public class DriverMapper {

    public Driver toDriver(DriverRequestDto driverDto){
        if (driverDto == null) {
            return null;
        }

        var driver = new Driver();

        if (Objects.nonNull(driverDto.getCode())) {
            driver.setCode(driverDto.getCode());
        }

        if (Objects.nonNull(driverDto.getName())) {
            driver.setName(driverDto.getName());
        }

        if (Objects.nonNull(driverDto.getEmail())) {
            driver.setEmail(driverDto.getEmail());
        }

        if (Objects.nonNull(driverDto.getCellphone())) {
            driver.setCellphone(driverDto.getCellphone());
        }

        if (Objects.nonNull(driverDto.isEnabled())) {
            driver.setEnabled(driverDto.isEnabled());
        }

        return driver;
    }

    public DriverResponseDto toResponseDto(Driver driver){

        if (driver == null) {
            return null;
        }

        var driverResponseDto = new DriverResponseDto();

        if (Objects.nonNull(driver.getUuid())) {
            driverResponseDto.setUUID(driver.getUuid());
        }
        if (Objects.nonNull(driver.getCode())) {
            driverResponseDto.setCode(driver.getCode());
        }

        if (Objects.nonNull(driver.getName())) {
            driverResponseDto.setName(driver.getName());
        }

        if (Objects.nonNull(driver.getEmail())) {
            driverResponseDto.setEmail(driver.getEmail());
        }

        if (Objects.nonNull(driver.getCellphone())) {
            driverResponseDto.setCellphone(driver.getCellphone());
        }

        if (Objects.nonNull(driver.isEnabled())) {
            driverResponseDto.setEnabled(driver.isEnabled());
        }

        return driverResponseDto;
    }

    public void update(Driver driverSource, Driver driverTarget){

        if (Objects.nonNull(driverSource.getUuid())) {
            driverTarget.setUuid(driverSource.getUuid());
        }

        if (Objects.nonNull(driverSource.getCode())) {
            driverTarget.setCode(driverSource.getCode());
        }

        if (Objects.nonNull(driverSource.getName())) {
            driverTarget.setName(driverSource.getName());
        }

        if (Objects.nonNull(driverSource.getEmail())) {
            driverTarget.setEmail(driverSource.getEmail());
        }

        if (Objects.nonNull(driverSource.getCellphone())) {
            driverTarget.setCellphone(driverSource.getCellphone());
        }

        if (Objects.nonNull(driverSource.isEnabled())) {
            driverTarget.setEnabled(driverSource.isEnabled());
        }
    }

}
