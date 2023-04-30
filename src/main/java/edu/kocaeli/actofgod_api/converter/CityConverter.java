package edu.kocaeli.actofgod_api.converter;

import edu.kocaeli.actofgod_api.dto.city.CityDto;
import edu.kocaeli.actofgod_api.dto.city.CreateCityDto;
import edu.kocaeli.actofgod_api.model.City;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CityConverter {
    private final ModelMapper modelMapper;

    public City toEntity(CityDto dto) {
        return modelMapper.map(dto, City.class);
    }

    public City toEntity(CreateCityDto dto) {
        return modelMapper.map(dto, City.class);
    }

    public CityDto toDto(City entity) {
        return modelMapper.map(entity, CityDto.class);
    }
}
