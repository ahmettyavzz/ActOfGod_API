package edu.kocaeli.actofgod_api.controller;

import edu.kocaeli.actofgod_api.dto.city.CityDto;
import edu.kocaeli.actofgod_api.dto.city.CreateCityDto;
import edu.kocaeli.actofgod_api.dto.city.UpdateCityDto;
import edu.kocaeli.actofgod_api.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/v1/city")
public class CityController {
    private final CityService cityService;

    @PostMapping
    public CityDto add(@RequestBody CreateCityDto createCityDto) {
        return cityService.add(createCityDto);
    }

    @GetMapping("/{id}")
    public CityDto getById(@PathVariable Long id) {
        return cityService.getById(id);
    }

    @GetMapping
    public List<CityDto> getAll() {
        return cityService.getAll();
    }

    @PutMapping("/{id}")
    public CityDto update(@PathVariable Long id, @RequestBody UpdateCityDto updateCityDto) {
        return cityService.update(id, updateCityDto);
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable Long id) {
        cityService.delete(id);
    }
}
