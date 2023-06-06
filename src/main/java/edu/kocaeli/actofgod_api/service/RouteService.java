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
                + "&mode=walking&sensor=false&key=YOUR_API_KEY";

        String jsonString = restTemplate.getForObject(apiUrl, String.class);

        RouteDto routeDto = new RouteDto();
        routeDto.setDistance(convertToMeters(JsonPath.read(jsonString, "$.routes[0].legs[0].distance.text")));
        routeDto.setDuration(convertToMinutes(JsonPath.read(jsonString, "$.routes[0].legs[0].duration.text")));

        return routeDto;
    }

    private int convertToMinutes(String input) {
        String[] parts = input.split(" ");
        int hours = 0;
        int minutes = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("hour") || parts[i].equals("hours")) {
                hours = Integer.parseInt(parts[i - 1]);
            } else if (parts[i].equals("min") || parts[i].equals("mins")) {
                minutes = Integer.parseInt(parts[i - 1]);
            }
        }
        return hours * 60 + minutes;
    }

    private int convertToMeters(String input) {
        String[] parts = input.split(" ");
        double distance=0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("km")) {
                distance = Double.parseDouble(parts[i - 1])*1000;
            } else if (parts[i].equals("m")) {
                distance = Double.parseDouble(parts[i - 1]);
            }
        }
        return (int) distance;
    }
}
