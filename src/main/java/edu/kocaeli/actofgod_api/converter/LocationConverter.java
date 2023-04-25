package edu.kocaeli.actofgod_api.converter;

import edu.kocaeli.actofgod_api.dto.location.CreateLocationDto;
import edu.kocaeli.actofgod_api.dto.location.LocationDto;
import edu.kocaeli.actofgod_api.model.Location;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationConverter {
    private final ModelMapper modelMapper;

    public Location toEntity(LocationDto dto) {
        return modelMapper.map(dto, Location.class);
    }

    public Location toEntity(CreateLocationDto dto) {
        return modelMapper.map(dto, Location.class);
    }

    public LocationDto toDto(Location entity) {
        return modelMapper.map(entity, LocationDto.class);
    }

}
