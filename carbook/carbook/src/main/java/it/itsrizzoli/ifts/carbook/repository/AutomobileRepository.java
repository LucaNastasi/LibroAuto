package it.itsrizzoli.ifts.carbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.itsrizzoli.ifts.carbook.model.Automobile;


public interface AutomobileRepository extends JpaRepository<Automobile, Integer> {

}
