package edu.kocaeli.actofgod_api.service;

import edu.kocaeli.actofgod_api.converter.DistrictConverter;
import edu.kocaeli.actofgod_api.dto.district.DistrictDto;
import edu.kocaeli.actofgod_api.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DistrictService {
    private final DistrictRepository districtRepository;
    private final DistrictConverter districtConverter;

    public List<DistrictDto> getByCityId(Long id) {
        return districtRepository.findByCityId(id).stream().map(districtConverter::toDto).collect(Collectors.toList());
    }
}
