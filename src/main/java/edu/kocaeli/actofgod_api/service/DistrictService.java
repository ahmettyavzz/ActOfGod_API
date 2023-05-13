package edu.kocaeli.actofgod_api.service;

import edu.kocaeli.actofgod_api.converter.DistrictConverter;
import edu.kocaeli.actofgod_api.dto.district.CreateDistrictDto;
import edu.kocaeli.actofgod_api.dto.district.DistrictDto;
import edu.kocaeli.actofgod_api.dto.district.UpdateDistrictDto;
import edu.kocaeli.actofgod_api.exception.ErrorStatusCode;
import edu.kocaeli.actofgod_api.exception.GeneralException;
import edu.kocaeli.actofgod_api.model.District;
import edu.kocaeli.actofgod_api.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DistrictService {
    private final DistrictRepository districtRepository;
    private final DistrictConverter districtConverter;

    public DistrictDto add(CreateDistrictDto createDistrictDto) {
        var forSave = districtConverter.toEntity(createDistrictDto);
        forSave.setCreatedDate(new Date());
        return districtConverter.toDto(districtRepository.save(forSave));
    }

    public DistrictDto getById(Long id) {
        var districtById = getDistrictIfFound(id);
        return districtConverter.toDto(districtById);
    }

    public List<DistrictDto> getAll() {
        return districtRepository.findAllByOrderByIdAsc().stream().map(districtConverter::toDto).collect(Collectors.toList());
    }

    public DistrictDto update(Long id, UpdateDistrictDto dto) {
        var forUpdateDistrict = getDistrictIfFound(id);
        forUpdateDistrict.setName(dto.getName());
        forUpdateDistrict.setUpdatedDate(new Date());
        return districtConverter.toDto(districtRepository.save(forUpdateDistrict));
    }

    private District getDistrictIfFound(Long id) {
        return districtRepository.findById(id).orElseThrow(
                () -> new GeneralException(ErrorStatusCode.DISTRICT_NOT_FOUND_BY_ID)
        );
    }

    public void delete(Long id) {
        districtRepository.deleteById(id);
    }
}
