package tech.escalab.springdeliveries.service.truck.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.escalab.springdeliveries.dao.truck.TruckRepositoryJpa;
import tech.escalab.springdeliveries.domain.truck.Truck;
import tech.escalab.springdeliveries.dto.truck.TruckRequestDto;
import tech.escalab.springdeliveries.dto.truck.TruckResponseDto;
import tech.escalab.springdeliveries.mapper.truck.TruckMapper;
import tech.escalab.springdeliveries.service.truck.TruckService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TruckServiceImpl implements TruckService {

    private final TruckRepositoryJpa truckRepositoryJpa;
    private TruckMapper truckMapper;
    @Override
    public List<TruckResponseDto> findAll() {

        return truckRepositoryJpa.findAll().stream().map(truck -> truckMapper.toResponseDto(truck)).collect(Collectors.toList());
    }

    @Override
    public Truck findByUuid(UUID uuid) {
        return truckRepositoryJpa.findById(uuid).get();
    }

    @Override
    public TruckResponseDto save(TruckRequestDto truckDto) {
        var truck = truckMapper.toTruck(truckDto);
        truckRepositoryJpa.save(truck);
        return truckMapper.toResponseDto(truck);
    }

    @Override
    public TruckResponseDto udpate(UUID uuid, TruckRequestDto truckDto) {
        var truckSource = truckMapper.toTruck(truckDto);
        var truckTarget = findByUuid(uuid);
        truckSource.setUuid(uuid);
        truckMapper.update(truckSource,truckTarget);
        truckRepositoryJpa.save(truckTarget);
        return truckMapper.toResponseDto(truckTarget);
    }

    @Override
    public TruckResponseDto delete(UUID uuid) {
        var truckDeleted = findByUuid(uuid);
        truckRepositoryJpa.deleteById(uuid);
        return truckMapper.toResponseDto(truckDeleted);
    }

}
