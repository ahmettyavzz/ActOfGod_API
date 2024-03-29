package edu.kocaeli.actofgod_api.controller;

import edu.kocaeli.actofgod_api.dto.route.RouteApiParameterDto;
import edu.kocaeli.actofgod_api.dto.route.RouteDto;
import edu.kocaeli.actofgod_api.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/v1/route")
public class RouteController {
    private final RouteService routeService;

    @PostMapping
    public RouteDto calculateRoute(@RequestBody RouteApiParameterDto routeApiParameterDto) {
        return routeService.calculateRoute(routeApiParameterDto);
    }
}
