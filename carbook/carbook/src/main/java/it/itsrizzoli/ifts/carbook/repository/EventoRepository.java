package it.itsrizzoli.ifts.carbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.itsrizzoli.ifts.carbook.model.Commento;
import it.itsrizzoli.ifts.carbook.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
