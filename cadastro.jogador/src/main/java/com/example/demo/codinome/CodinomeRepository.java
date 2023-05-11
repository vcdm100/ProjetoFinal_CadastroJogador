package com.example.demo.codinome;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodinomeRepository extends JpaRepository<Codinome, String> {
	Optional<Codinome> findById(String id);
}
