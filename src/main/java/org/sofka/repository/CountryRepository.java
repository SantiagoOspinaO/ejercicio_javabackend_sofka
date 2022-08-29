package org.sofka.repository;

import org.sofka.domain.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

    Optional<Country> findCountryByCode(String code);
}
