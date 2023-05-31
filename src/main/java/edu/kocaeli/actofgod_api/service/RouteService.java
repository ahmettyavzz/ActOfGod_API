package edu.kocaeli.actofgod_api.service;

import com.jayway.jsonpath.JsonPath;
import edu.kocaeli.actofgod_api.dto.route.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class RouteService {
    private final RestTemplate restTemplate;

    public RouteDto calculateRoute(RouteApiParameterDto routeApiParameterDto) {
        String apiUrl = "https://maps.google.com/maps/api/directions/json?origin="
                + routeApiParameterDto.getOriginLatitude() + ","
                + routeApiParameterDto.getOriginLongitude()
                + "&destination=" + routeApiParameterDto.getDestinationLatitude() + ","
                + routeApiParameterDto.getDestinationLongitude()
                + "&mode=walking&sensor=false&key=AIzaSyAd4VpzsRvbAEE2vXpKYUud_J0tDxW8zmE";

        String jsonString = restTemplate.getForObject(apiUrl, String.class);

        RouteDto routeDto = new RouteDto();
        routeDto.setDistance(JsonPath.read(jsonString, "$.routes[0].legs[0].distance.text"));
        routeDto.setDuration(JsonPath.read(jsonString, "$.routes[0].legs[0].duration.text"));

        return routeDto;
    }
}
