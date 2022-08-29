package org.sofka.repository;

import org.sofka.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Integer> {

    Optional<Team> findTeamByCode(String team);
}
