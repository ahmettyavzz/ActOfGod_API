package edu.kocaeli.actofgod_api.dto.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateDistrictDto {
    private String name;
    private Long cityId;
}
