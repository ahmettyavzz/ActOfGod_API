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
@Table(name = "districts")
public class District extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;
    @OneToOne(mappedBy = "district")
    private Location location;
}
