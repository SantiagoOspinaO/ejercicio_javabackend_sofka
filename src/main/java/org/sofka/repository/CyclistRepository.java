package org.sofka.repository;

import org.sofka.model.Cyclist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface CyclistRepository extends CrudRepository<Cyclist, Integer> {

    Optional<Cyclist> findCyclistByCompetitorNumber(int competitorNumber);
}
