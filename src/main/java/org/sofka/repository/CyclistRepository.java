package org.sofka.repository;

import org.sofka.domain.Cyclist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CyclistRepository extends CrudRepository<Cyclist, Integer> {

    Optional<Cyclist> findCyclistByCompetitorNumber(String competitorNumber);

    List<Cyclist> findByCyclingTeamTeamCode(String team);
}
