package tech.escalab.springdeliveries.controller.driver;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.escalab.springdeliveries.domain.driver.Driver;
import tech.escalab.springdeliveries.swagger.DriverSwagger;
import tech.escalab.springdeliveries.dto.driver.DriverRequestDto;
import tech.escalab.springdeliveries.dto.driver.DriverResponseDto;
import tech.escalab.springdeliveries.service.driver.DriverService;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/driver")
public class DriverController implements DriverSwagger {

    private final DriverService driverService;
    @Override
    @GetMapping
    public List<DriverResponseDto> findAll() {

        return driverService.findAll();
    }
    @Override
    @PostMapping("")
    public DriverResponseDto save(@Valid  @RequestBody DriverRequestDto driver){

        return driverService.save(driver);

    }

    @Override
    @PutMapping("/{uuid}")
    public void update(
            @PathVariable UUID uuid,
            @Valid @RequestBody DriverRequestDto driver
    ) {
        driverService.udpate(uuid,driver);
    }

    @Override
    @DeleteMapping("/{uuid}")
    public DriverResponseDto delete(
            @PathVariable UUID uuid
    ) {
        return driverService.delete(uuid);
    }
}
