package edu.kocaeli.actofgod_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocationDto {
    private String name;
    private Double latitude;
    private Double longitude;
    private Long capacity;
}
