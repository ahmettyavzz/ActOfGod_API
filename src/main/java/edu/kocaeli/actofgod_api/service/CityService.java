package edu.kocaeli.actofgod_api.service;

import edu.kocaeli.actofgod_api.converter.CityConverter;
import edu.kocaeli.actofgod_api.dto.city.CityDto;
import edu.kocaeli.actofgod_api.dto.city.CreateCityDto;
import edu.kocaeli.actofgod_api.dto.city.UpdateCityDto;
import edu.kocaeli.actofgod_api.exception.ErrorStatusCode;
import edu.kocaeli.actofgod_api.exception.GeneralException;
import edu.kocaeli.actofgod_api.model.City;
import edu.kocaeli.actofgod_api.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CityService {
    private final CityRepository cityRepository;
    private final CityConverter cityConverter;

    public CityDto add(CreateCityDto createCityDto) {
        var forSave = cityConverter.toEntity(createCityDto);
        forSave.setCreatedDate(new Date());
        return cityConverter.toDto(cityRepository.save(forSave));
    }

    public CityDto getById(Long id) {
        var cityById = getCityIfFound(id);
        return cityConverter.toDto(cityById);
    }

    public List<CityDto> getAll() {
        return cityRepository.findAll().stream().map(cityConverter::toDto).collect(Collectors.toList());
    }

    public CityDto update(Long id, UpdateCityDto dto) {
        var forUpdateCity = getCityIfFound(id);
        forUpdateCity.setName(dto.getName());
        forUpdateCity.setUpdatedDate(new Date());
        return cityConverter.toDto(cityRepository.save(forUpdateCity));
    }

    private City getCityIfFound(Long id) {
        return cityRepository.findById(id).orElseThrow(
                () -> new GeneralException(ErrorStatusCode.CITY_NOT_FOUND_BY_ID)
        );
    }

    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
