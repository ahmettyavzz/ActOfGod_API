package edu.kocaeli.actofgod_api.repository;

import edu.kocaeli.actofgod_api.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> findAllByOrderByIdAsc();
    List<District> findByCityId(Long cityId);
}
