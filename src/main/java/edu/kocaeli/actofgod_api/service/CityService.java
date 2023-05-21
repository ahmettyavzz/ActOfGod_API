package edu.kocaeli.actofgod_api.service;

import edu.kocaeli.actofgod_api.converter.CityConverter;
import edu.kocaeli.actofgod_api.dto.city.CityDto;
import edu.kocaeli.actofgod_api.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CityService {
    private final CityRepository cityRepository;
    private final CityConverter cityConverter;

    public List<CityDto> getAll() {
        return cityRepository.findAllByOrderByIdAsc().stream().map(cityConverter::toDto).collect(Collectors.toList());
    }
}
