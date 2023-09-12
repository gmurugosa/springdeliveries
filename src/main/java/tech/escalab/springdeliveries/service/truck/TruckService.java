package tech.escalab.springdeliveries.service.truck;

import tech.escalab.springdeliveries.domain.truck.Truck;
import tech.escalab.springdeliveries.dto.truck.TruckRequestDto;
import tech.escalab.springdeliveries.dto.truck.TruckResponseDto;

import java.util.List;
import java.util.UUID;

public interface TruckService {
        List<TruckResponseDto> findAll();

        Truck findByUuid(UUID uuid);

        TruckResponseDto save(TruckRequestDto truck);

        TruckResponseDto udpate(UUID uuid, TruckRequestDto truckDto);

        TruckResponseDto delete(UUID uuid);
 }
