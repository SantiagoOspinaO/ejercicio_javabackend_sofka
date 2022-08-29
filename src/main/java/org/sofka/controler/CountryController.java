package org.sofka.controler;

import org.sofka.model.Country;
import org.sofka.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping()
    public List<Country> findAllCountries() {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Country> findCountryByCode(@PathVariable(name = "code") String code) {
        Optional<Country> country = countryRepository.findCountryByCode(code);
        return country
                .map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addCountry")
    public Country saveCountry(@Validated @RequestBody Country country) {
        return countryRepository.save(country);
    }

    @PutMapping("/{id}")
    public Country updateCountry(@RequestBody Country newCountry, @PathVariable int id) {
        return countryRepository.findById(id).map(country -> {
            country.setName(newCountry.getName());
            return countryRepository.save(country);
        }).orElseGet(() -> {
            return countryRepository.save(newCountry);
        });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable int id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
