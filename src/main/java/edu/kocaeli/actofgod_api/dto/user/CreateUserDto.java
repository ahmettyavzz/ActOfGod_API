package edu.kocaeli.actofgod_api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
