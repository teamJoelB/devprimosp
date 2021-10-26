package fr.joel.repository;

import org.springframework.data.repository.CrudRepository;

import fr.joel.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
