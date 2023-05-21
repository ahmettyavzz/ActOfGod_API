package edu.kocaeli.actofgod_api.converter;

import edu.kocaeli.actofgod_api.dto.city.CityDto;
import edu.kocaeli.actofgod_api.model.City;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CityConverter {
    private final ModelMapper modelMapper;

    public CityDto toDto(City entity) {
        return modelMapper.map(entity, CityDto.class);
    }
}
