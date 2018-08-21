package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Vehicule;

//@Repository
public interface VehiculeRepo extends JpaRepository<Vehicule, Long> {

}