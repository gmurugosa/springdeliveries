package tech.escalab.springdeliveries.dao.packageproducts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.escalab.springdeliveries.domain.packagedata.PackageData;
import tech.escalab.springdeliveries.domain.packageproducts.PackageProducts;

import java.util.List;
import java.util.UUID;

@Repository
public interface PackageProductsRepositoryJpa extends CrudRepository<PackageProducts, UUID> {
    List<PackageProducts> findAll();
}
