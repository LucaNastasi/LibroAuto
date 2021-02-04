package it.itsrizzoli.ifts.carbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.itsrizzoli.ifts.carbook.model.Commento;

public interface CommentoRepository extends JpaRepository<Commento, String> {

}
