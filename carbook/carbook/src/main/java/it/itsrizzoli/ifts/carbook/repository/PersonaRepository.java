package it.itsrizzoli.ifts.carbook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.itsrizzoli.ifts.carbook.model.Persona;


public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	@Query("SELECT p FROM Persona p where email= :email and password= :password")
	public Optional<Persona> match(@Param("email") String email, @Param("password") String password);
}
