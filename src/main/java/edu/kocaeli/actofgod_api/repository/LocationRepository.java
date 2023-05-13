package edu.kocaeli.actofgod_api.repository;

import edu.kocaeli.actofgod_api.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAllByOrderByIdAsc();
}
