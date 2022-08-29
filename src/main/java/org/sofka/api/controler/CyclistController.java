package org.sofka.api.controler;

import org.sofka.domain.Cyclist;
import org.sofka.repository.CyclistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CyclistController {

    @Autowired
    private CyclistRepository cyclistRepository;

    @GetMapping("/api/cyclists")
    public ResponseEntity<List<Cyclist>> findAllCyclists(@RequestParam Map<String, String> reqParam) {
        if (!reqParam.isEmpty()) return ResponseEntity.badRequest().build();
        List<Cyclist> cyclists = new ArrayList<>();
        cyclistRepository.findAll().forEach(cyclists::add);
        return ResponseEntity.ok().body(cyclists);
    }

    @PostMapping("/api/newCyclist")
    public Cyclist saveNewCyclist(@Validated @RequestBody Cyclist newCyclist) {
        return cyclistRepository.save(newCyclist);
    }

    @GetMapping("/api/cyclist/{competitorNumber}")
    public ResponseEntity<Cyclist> findCyclistByCompetitorNumber(
            @PathVariable(name = "competitorNumber") String competitorNumber) {
        Optional<Cyclist> cyclist = cyclistRepository.findCyclistByCompetitorNumber(competitorNumber);
        if (cyclist.isPresent()) return ResponseEntity.ok().body(cyclist.get());
        else return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/api/cyclists", method = RequestMethod.GET, params = "team")
    public List<Cyclist> findCyclistsByTeamCode(
            @RequestParam(name = "team") String team) {
        List<Cyclist> cyclists = new ArrayList<>();
        cyclistRepository.findByCyclingTeamTeamCode(team).forEach(cyclists::add);
        return cyclists;
    }
}
