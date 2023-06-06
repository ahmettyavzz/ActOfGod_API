package edu.kocaeli.actofgod_api.converter;

import edu.kocaeli.actofgod_api.dto.user.CreateUserDto;
import edu.kocaeli.actofgod_api.dto.user.UserDto;
import edu.kocaeli.actofgod_api.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {
    private final ModelMapper modelMapper;

    public User toEntity(CreateUserDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setBirthYear(dto.getBirthYear());
        user.setTcNo(dto.getTcNo());
        user.setAndroidId(dto.getAndroidId());
        return user;
    }

    public UserDto toDto(User entity) {
        return modelMapper.map(entity, UserDto.class);
    }

}
