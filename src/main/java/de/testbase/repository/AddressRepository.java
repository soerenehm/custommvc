package de.testbase.repository;

import de.testbase.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
