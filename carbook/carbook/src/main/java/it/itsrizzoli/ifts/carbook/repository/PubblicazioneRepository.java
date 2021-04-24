package it.itsrizzoli.ifts.carbook.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.itsrizzoli.ifts.carbook.model.Persona;
import it.itsrizzoli.ifts.carbook.model.Pubblicazione;

public interface PubblicazioneRepository extends JpaRepository<Pubblicazione, Integer> {
	
	@Query("select p from Pubblicazione p where p.persona = :persona")
	public List<Pubblicazione> byPersona(@Param("persona")Persona persona);

}
