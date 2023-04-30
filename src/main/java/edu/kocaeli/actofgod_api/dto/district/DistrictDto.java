package edu.kocaeli.actofgod_api.dto.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DistrictDto {
    private Long id;
    private String name;
    private String cityName;
}
