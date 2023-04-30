package edu.kocaeli.actofgod_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "locations")
public class Location extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;
    private Long capacity;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
}
