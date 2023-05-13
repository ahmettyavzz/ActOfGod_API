package edu.kocaeli.actofgod_api.repository;

import edu.kocaeli.actofgod_api.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByOrderByIdAsc();
}
