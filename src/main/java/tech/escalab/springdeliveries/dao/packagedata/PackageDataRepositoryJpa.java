package tech.escalab.springdeliveries.dao.packagedata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.escalab.springdeliveries.domain.packagedata.PackageData;
import tech.escalab.springdeliveries.domain.truck.Truck;

import java.util.List;
import java.util.UUID;

@Repository
public interface PackageDataRepositoryJpa extends CrudRepository<PackageData, UUID> {
    List<PackageData> findAll();
}
