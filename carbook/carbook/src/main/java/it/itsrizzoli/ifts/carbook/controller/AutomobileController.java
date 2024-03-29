package it.itsrizzoli.ifts.carbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.sun.org.apache.bcel.internal.generic.AALOAD;

import it.itsrizzoli.ifts.carbook.exceptions.NotFoundException;
import it.itsrizzoli.ifts.carbook.model.Automobile;
import it.itsrizzoli.ifts.carbook.model.Persona;
import it.itsrizzoli.ifts.carbook.model.Pubblicazione;
import it.itsrizzoli.ifts.carbook.repository.AutomobileRepository;

@CrossOrigin(origins = "*")
@RestController

public class AutomobileController {

	@Autowired 
	private AutomobileRepository repository;
	
	@GetMapping("/automobili")
	public List<Automobile> all()
	{
		return repository.findAll();
	}
	
	@GetMapping("/automobili/{id}")
	public Automobile byID(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException());
	
}
	
	@PostMapping("/automobili") // api
	public Automobile inserisci(@RequestBody Automobile automobile) {
		return repository.save(automobile);
	}
	

	@PutMapping("/automobili/{id}") // api
	public Automobile aggiorna(Automobile automobile, @PathVariable Integer id) {
		return repository.findById(id).map(a -> {
		a.setAlimentazione(automobile.getAlimentazione());
		a.setPotenza(automobile.getPotenza());
		a.setChilometraggio(automobile.getChilometraggio());
		a.setMarca(automobile.getMarca());
		a.setCitta(automobile.getCitta());
		a.setAnnoImmatricolazione(automobile.getAnnoImmatricolazione());
		a.setFotoAuto(automobile.getFotoAuto());
		a.setModello(automobile.getModello());
		a.setCosto(automobile.getCosto());
		a.setPubblicazioni(automobile.getPubblicazioni());
		a.setStato(automobile.getStato());
		a.setCambio(automobile.getCambio());
		
			return repository.save(a);
		}).orElseGet(() -> {
			automobile.setIdAutomobile(id);;
			return repository.save(automobile);
		});
	}
		
		
		@DeleteMapping ("/automobili/{id}")
		public void elimina (@PathVariable Integer id) {
			repository.delete(repository.findById(id).orElseThrow(() -> new NotFoundException())); ;
		}
		
		@DeleteMapping("/automobili/")
		public void deleteAll() {
		 repository.deleteAll();

		} 
	}

	
	
	
	
	
	
	
	
	
	

