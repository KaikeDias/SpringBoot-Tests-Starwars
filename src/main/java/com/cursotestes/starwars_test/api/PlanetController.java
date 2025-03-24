package com.cursotestes.starwars_test.api;

import com.cursotestes.starwars_test.domain.Planet;
import com.cursotestes.starwars_test.domain.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planets")
public class PlanetController {
    @Autowired
    private PlanetService planetService;

    @PostMapping
    public ResponseEntity<Planet> create(@RequestBody Planet planet) {
        Planet createdPlanet = planetService.create(planet);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlanet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> getPlanetById(@PathVariable long id) {
        return planetService.findById(id).map(planet -> ResponseEntity.ok(planet))
                .orElse(ResponseEntity.notFound().build());
    }
}
