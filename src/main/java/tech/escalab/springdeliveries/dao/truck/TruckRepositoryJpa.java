package tech.escalab.springdeliveries.dao.truck;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.escalab.springdeliveries.domain.truck.Truck;

import java.util.List;
import java.util.UUID;
@Repository
public interface TruckRepositoryJpa extends CrudRepository<Truck, UUID> {
    List<Truck> findAll();
}
