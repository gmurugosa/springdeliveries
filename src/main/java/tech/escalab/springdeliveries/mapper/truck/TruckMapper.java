package tech.escalab.springdeliveries.mapper.truck;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import tech.escalab.springdeliveries.domain.driver.Driver;
import tech.escalab.springdeliveries.domain.truck.Truck;
import tech.escalab.springdeliveries.dto.driver.DriverResponseDto;
import tech.escalab.springdeliveries.dto.truck.TruckRequestDto;
import tech.escalab.springdeliveries.dto.truck.TruckResponseDto;

import java.util.Objects;
@Component
public class TruckMapper {

    public Truck toTruck(TruckRequestDto truckDto){
        if (truckDto == null) {
            return null;
        }

        var truck = new Truck();

        if (Objects.nonNull(truckDto.getCode())) {
            truck.setCode(truckDto.getCode());
        }

        if (Objects.nonNull(truckDto.isEnabled())) {
            truck.setEnabled(truckDto.isEnabled());
        }

        return truck;
    }

    public TruckResponseDto toResponseDto(Truck truck){

        if (truck == null) {
            return null;
        }

        var truckResponseDto = new TruckResponseDto();

        if (Objects.nonNull(truck.getUuid())) {
            truckResponseDto.setUUID(truck.getUuid());
        }
        if (Objects.nonNull(truck.isEnabled())) {
            truckResponseDto.setEnabled(truck.isEnabled());
        }

        return truckResponseDto;
    }

    public void update(Truck truckSource, Truck truckTarget){

        if (Objects.nonNull(truckSource.getUuid())) {
            truckTarget.setUuid(truckSource.getUuid());
        }

        if (Objects.nonNull(truckSource.getCode())) {
            truckTarget.setCode(truckSource.getCode());
        }

        if (Objects.nonNull(truckSource.isEnabled())) {
            truckTarget.setEnabled(truckSource.isEnabled());
        }
    }



}
