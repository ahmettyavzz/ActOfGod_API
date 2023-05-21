package edu.kocaeli.actofgod_api.converter;

import edu.kocaeli.actofgod_api.dto.district.DistrictDto;
import edu.kocaeli.actofgod_api.model.District;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DistrictConverter {
    private final ModelMapper modelMapper;

    public DistrictDto toDto(District entity) {
        return modelMapper.map(entity, DistrictDto.class);
    }
}
