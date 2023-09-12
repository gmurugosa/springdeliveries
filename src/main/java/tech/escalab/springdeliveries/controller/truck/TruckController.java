package tech.escalab.springdeliveries.controller.truck;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.escalab.springdeliveries.domain.truck.Truck;
import tech.escalab.springdeliveries.dto.truck.TruckRequestDto;
import tech.escalab.springdeliveries.dto.truck.TruckResponseDto;
import tech.escalab.springdeliveries.service.truck.TruckService;
import tech.escalab.springdeliveries.swagger.TruckSwagger;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/Truck")
public class TruckController implements TruckSwagger {

    private final TruckService truckService;

    @Override
    @GetMapping
    public List<TruckResponseDto> findAll() {

        return truckService.findAll();
    }
    @Override
    @PostMapping("")
    public TruckResponseDto save(@Valid  @RequestBody TruckRequestDto Truck){

        return truckService.save(Truck);

    }

    @Override
    @PutMapping("/{uuid}")
    public void update(
            @PathVariable UUID uuid,
            @Valid @RequestBody TruckRequestDto Truck
    ) {
        truckService.udpate(uuid,Truck);
    }

    @Override
    @DeleteMapping("/{uuid}")
    public TruckResponseDto delete(
            @PathVariable UUID uuid
    ) {
        return truckService.delete(uuid);
    }
}
