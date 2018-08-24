package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.RoleCollaborateur;

public interface RoleCollaborateurRepo extends JpaRepository<RoleCollaborateur, Long> {

}
