package edu.kocaeli.actofgod_api.controller;

import edu.kocaeli.actofgod_api.dto.district.CreateDistrictDto;
import edu.kocaeli.actofgod_api.dto.district.DistrictDto;
import edu.kocaeli.actofgod_api.dto.district.UpdateDistrictDto;
import edu.kocaeli.actofgod_api.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/v1/district")
public class DistrictController {
    private final DistrictService districtService;

    @PostMapping
    public DistrictDto add(@RequestBody CreateDistrictDto createDistrictDto) {
        return districtService.add(createDistrictDto);
    }

    @GetMapping("/{id}")
    public DistrictDto getById(@PathVariable Long id) {
        return districtService.getById(id);
    }

    @GetMapping
    public List<DistrictDto> getAll() {
        return districtService.getAll();
    }

    @PutMapping("/{id}")
    public DistrictDto update(@PathVariable Long id, @RequestBody UpdateDistrictDto updateDistrictDto) {
        return districtService.update(id, updateDistrictDto);
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable Long id) {
        districtService.delete(id);
    }
}
