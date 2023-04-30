package edu.kocaeli.actofgod_api.controller;

import edu.kocaeli.actofgod_api.dto.location.LocationDto;
import edu.kocaeli.actofgod_api.dto.location.CreateLocationDto;
import edu.kocaeli.actofgod_api.dto.location.UpdateLocationDto;
import edu.kocaeli.actofgod_api.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    public LocationDto add(@RequestBody CreateLocationDto createLocationDto) {
        return locationService.add(createLocationDto);
    }

    @GetMapping("/{id}")
    public LocationDto getById(@PathVariable Long id) {
        return locationService.getById(id);
    }

    @GetMapping
    public List<LocationDto> getAll() {
        return locationService.getAll();
    }

    @PutMapping("/{id}")
    public LocationDto update(@PathVariable Long id, @RequestBody UpdateLocationDto updateLocationDto) {
        return locationService.update(id, updateLocationDto);
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable Long id) {
        locationService.delete(id);
    }
}
