package edu.kocaeli.actofgod_api.controller;

import edu.kocaeli.actofgod_api.dto.city.CityDto;
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

    @GetMapping
    public List<CityDto> getAll() {
        return cityService.getAll();
    }
}
