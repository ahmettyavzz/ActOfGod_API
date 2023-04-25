package edu.kocaeli.actofgod_api.controller;

import edu.kocaeli.actofgod_api.dto.user.UpdateUserDto;
import edu.kocaeli.actofgod_api.dto.user.UserDto;
import edu.kocaeli.actofgod_api.dto.user.CreateUserDto;
import edu.kocaeli.actofgod_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDto add(@RequestBody CreateUserDto createUserDto) {
        return userService.add(createUserDto);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UpdateUserDto dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
