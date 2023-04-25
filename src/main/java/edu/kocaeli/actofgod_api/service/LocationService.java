package edu.kocaeli.actofgod_api.service;

import edu.kocaeli.actofgod_api.converter.LocationConverter;
import edu.kocaeli.actofgod_api.dto.location.CreateLocationDto;
import edu.kocaeli.actofgod_api.dto.location.LocationDto;
import edu.kocaeli.actofgod_api.dto.location.UpdateLocationDto;
import edu.kocaeli.actofgod_api.exception.ErrorStatusCode;
import edu.kocaeli.actofgod_api.exception.GeneralException;
import edu.kocaeli.actofgod_api.model.Location;
import edu.kocaeli.actofgod_api.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationConverter locationConverter;

    public LocationDto add(CreateLocationDto createLocationDto) {
        var forSave = locationConverter.toEntity(createLocationDto);
        forSave.setCreatedDate(new Date());
        return locationConverter.toDto(locationRepository.save(forSave));
    }

    public LocationDto getById(Long id) {
        var locationById = getLocationIfFound(id);
        return locationConverter.toDto(locationById);
    }

    public List<LocationDto> getAll() {
        return locationRepository.findAll().stream().map(locationConverter::toDto).collect(Collectors.toList());
    }

    public LocationDto update(Long id, UpdateLocationDto dto) {
        var forUpdateLocation = getLocationIfFound(id);
        forUpdateLocation.setName(dto.getName());
        forUpdateLocation.setLatitude(dto.getLatitude());
        forUpdateLocation.setLongitude(dto.getLongitude());
        forUpdateLocation.setCapacity(dto.getCapacity());
        forUpdateLocation.setUpdatedDate(new Date());
        return locationConverter.toDto(locationRepository.save(forUpdateLocation));
    }

    private Location getLocationIfFound(Long id) {
        return locationRepository.findById(id).orElseThrow(
                () -> new GeneralException(ErrorStatusCode.LOCATION_NOT_FOUND_BY_ID)
        );
    }

    public void delete(Long id) {
        locationRepository.deleteById(id);
    }
}