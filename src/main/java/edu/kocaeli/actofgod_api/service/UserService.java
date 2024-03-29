package edu.kocaeli.actofgod_api.service;

import edu.kocaeli.actofgod_api.converter.UserConverter;
import edu.kocaeli.actofgod_api.dto.user.CreateUserDto;
import edu.kocaeli.actofgod_api.dto.user.UpdateUserDto;
import edu.kocaeli.actofgod_api.dto.user.UserDto;
import edu.kocaeli.actofgod_api.exception.ErrorStatusCode;
import edu.kocaeli.actofgod_api.exception.GeneralException;
import edu.kocaeli.actofgod_api.model.User;
import edu.kocaeli.actofgod_api.repository.UserRepository;
import edu.kocaeli.actofgod_api.util.EmailValidationUtil;
import edu.kocaeli.actofgod_api.util.PhoneNumberValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserConverter userConverter;
    private final UserRepository userRepository;

    public UserDto add(CreateUserDto createUserDto) {
        var forSave = userConverter.toEntity(createUserDto);
        forSave.setCreatedDate(new Date());
        return userConverter.toDto(userRepository.save(forSave));
    }

    public UserDto getById(Long id) {
        var userById = getUserIfFound(id);
        return userConverter.toDto(userById);
    }

    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(userConverter::toDto).collect(Collectors.toList());
    }

    public UserDto update(Long id, UpdateUserDto dto) {
        var forUpdateUser = getUserIfFound(id);
        forUpdateUser.setFirstName(dto.getFirstName());
        forUpdateUser.setLastName(dto.getLastName());
        forUpdateUser.setUpdatedDate(new Date());
        return userConverter.toDto(userRepository.save(forUpdateUser));
    }

    private User getUserIfFound(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new GeneralException(ErrorStatusCode.USER_NOT_FOUND_BY_ID)
        );
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
