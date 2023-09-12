package tech.escalab.springdeliveries.service.driver;

import tech.escalab.springdeliveries.domain.driver.Driver;
import tech.escalab.springdeliveries.dto.driver.DriverRequestDto;
import tech.escalab.springdeliveries.dto.driver.DriverResponseDto;

import java.util.List;
import java.util.UUID;

public interface DriverService {

    List<DriverResponseDto> findAll();

    Driver findByUuid(UUID uuid);

    DriverResponseDto save(DriverRequestDto driver);

    DriverResponseDto udpate(UUID uuid, DriverRequestDto driverDto);

    DriverResponseDto delete(UUID uuid);
}
