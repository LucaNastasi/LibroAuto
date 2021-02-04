package it.itsrizzoli.ifts.carbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.itsrizzoli.ifts.carbook.model.Messaggio;

public interface MessaggioRepository extends JpaRepository<Messaggio, String> {

}
