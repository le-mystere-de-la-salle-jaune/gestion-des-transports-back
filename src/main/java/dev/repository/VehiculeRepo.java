package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.domain.Vehicule;

@Repository
public interface VehiculeRepo extends JpaRepository<Vehicule, Long> {

}
