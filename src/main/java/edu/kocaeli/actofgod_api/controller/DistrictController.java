package edu.kocaeli.actofgod_api.controller;

import edu.kocaeli.actofgod_api.dto.district.DistrictDto;
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

    @GetMapping
    public List<DistrictDto> getAll() {
        return districtService.getAll();
    }
}
