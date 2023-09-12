package tech.escalab.springdeliveries.service.driver.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.escalab.springdeliveries.domain.driver.Driver;
import tech.escalab.springdeliveries.dao.driver.DriverRepositoryJpa;
import tech.escalab.springdeliveries.dto.driver.DriverRequestDto;
import tech.escalab.springdeliveries.dto.driver.DriverResponseDto;
import tech.escalab.springdeliveries.mapper.driver.DriverMapper;
import tech.escalab.springdeliveries.service.driver.DriverService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepositoryJpa driverRepositoryJpa;
    private DriverMapper driverMapper;
    @Override
    public List<DriverResponseDto> findAll() {

        return driverRepositoryJpa.findAll().stream().map(driver-> driverMapper.toResponseDto(driver)).collect(Collectors.toList());
    }

    @Override
    public Driver findByUuid(UUID uuid) {
        return driverRepositoryJpa.findById(uuid).get();
    }

    @Override
    public DriverResponseDto save(DriverRequestDto driverDto) {
        var driver = driverMapper.toDriver(driverDto);
        driverRepositoryJpa.save(driver);
        return driverMapper.toResponseDto(driver);
    }

    @Override
    public DriverResponseDto udpate(UUID uuid, DriverRequestDto driverDto) {
        var driverSource = driverMapper.toDriver(driverDto);
        driverSource.setUuid(uuid);
        var driverTarget = findByUuid(uuid);
        driverMapper.update(driverSource,driverTarget);
        driverRepositoryJpa.save(driverTarget);
        return driverMapper.toResponseDto(driverTarget);
    }

    @Override
    public DriverResponseDto delete(UUID uuid) {
        var driverDeleted = findByUuid(uuid);
        driverRepositoryJpa.deleteById(uuid);
        return driverMapper.toResponseDto(driverDeleted);
    }
}
