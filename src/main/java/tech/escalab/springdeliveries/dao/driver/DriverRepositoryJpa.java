package tech.escalab.springdeliveries.dao.driver;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.escalab.springdeliveries.domain.driver.Driver;

import java.util.List;
import java.util.UUID;
@Repository
public interface DriverRepositoryJpa extends CrudRepository<Driver, UUID> {
    List<Driver> findAll();

}
