package it.itsrizzoli.ifts.carbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.itsrizzoli.ifts.carbook.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {

}
