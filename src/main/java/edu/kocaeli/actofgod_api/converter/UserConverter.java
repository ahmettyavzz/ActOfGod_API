package edu.kocaeli.actofgod_api.converter;

import edu.kocaeli.actofgod_api.dto.UserDto;
import edu.kocaeli.actofgod_api.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {
    private final ModelMapper modelMapper;

    public User toEntity(UserDto dto) {
        return modelMapper.map(dto, User.class);
    }

    public UserDto toDto(User entity) {
        return modelMapper.map(entity, UserDto.class);
    }

}
