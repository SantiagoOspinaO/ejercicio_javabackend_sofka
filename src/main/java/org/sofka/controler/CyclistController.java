package org.sofka.controler;

import org.sofka.model.Cyclist;
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
@RequestMapping("/api/cyclist")
public class CyclistController {

    @Autowired
    private CyclistRepository cyclistRepository;

    @GetMapping()
    public ResponseEntity<List<Cyclist>> findAllCyclists(@RequestParam Map<String, String> reqParam) {
        if (!reqParam.isEmpty()) return ResponseEntity.badRequest().build();
        List<Cyclist> cyclists = new ArrayList<>();
        cyclistRepository.findAll().forEach(cyclists::add);
        return ResponseEntity.ok().body(cyclists);
    }

    @PostMapping("/addCyclist")
    public Cyclist saveNewCyclist(@Validated @RequestBody Cyclist newCyclist) {
        return cyclistRepository.save(newCyclist);
    }

    @GetMapping("/{competitorNumber}")
    public ResponseEntity<Cyclist> findCyclistByCompetitorNumber(
            @PathVariable(name = "competitorNumber") int competitorNumber) {
        Optional<Cyclist> cyclist = cyclistRepository.findCyclistByCompetitorNumber(competitorNumber);
        return cyclist
                .map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
