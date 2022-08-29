package org.sofka.controler;

import org.sofka.model.Team;
import org.sofka.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping()
    public List<Team> findAllCyclingTeams() {
        List<Team> teams = new ArrayList<>();
        teamRepository.findAll().forEach(teams::add);
        return teams;
    }

    @PostMapping("/addTeam")
    public Team saveCyclingTeam(@Validated @RequestBody Team newTeam) {
        return teamRepository.save(newTeam);
    }

    @GetMapping("/{team_code}")
    public ResponseEntity<Team> findCyclingTeamByCode(@PathVariable(name = "team_code") String teamCode) {
        Optional<Team> team = teamRepository.findTeamByCode(teamCode);
        return team
                .map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
