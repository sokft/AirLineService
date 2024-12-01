package com.cau.airline.controller;


import com.cau.airline.entity.Country;
import com.cau.airline.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    // Create
    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    // Read All
    @GetMapping
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Read by ID
    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable String id) {
        return countryRepository.findById(id).orElse(null);
    }

    // Update
    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable String id, @RequestBody Country country) {
        Country existingCountry = countryRepository.findById(id).orElse(null);
        if (existingCountry != null) {
            existingCountry.setCountryName(country.getCountryName());
            existingCountry.setContinent(country.getContinent());
            return countryRepository.save(existingCountry);
        }
        return null;
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable String id) {
        countryRepository.deleteById(id);
        return "Country with ID " + id + " deleted successfully.";
    }
}
