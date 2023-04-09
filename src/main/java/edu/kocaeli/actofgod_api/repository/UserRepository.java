package edu.kocaeli.actofgod_api.repository;

import edu.kocaeli.actofgod_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
