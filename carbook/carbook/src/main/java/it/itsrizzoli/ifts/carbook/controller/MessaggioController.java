package it.itsrizzoli.ifts.carbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.itsrizzoli.ifts.carbook.exceptions.NotFoundException;
import it.itsrizzoli.ifts.carbook.model.Messaggio;
import it.itsrizzoli.ifts.carbook.repository.MessaggioRepository;

@RestController
public class MessaggioController {

	@Autowired
	private MessaggioRepository repository; //proprietà
	
	@GetMapping("/messaggi")	//api
	public List<Messaggio> all() {
	return repository.findAll();
	}
	
	
	@GetMapping("/messaggi/{id}")	//api
	public Messaggio byID(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	@PostMapping("/messaggi")	//api
	public Messaggio inserisci(@RequestBody Messaggio messaggio) {
		return repository.save(messaggio);
	}
	
	@PutMapping("/messaggi/{id_messaggio}") //api
	public Messaggio aggiorna(@RequestBody Messaggio messaggio, @PathVariable Integer id)  {
		return repository.findById(id).map(m -> {
					m.setContenutoMessaggio(messaggio.getContenutoMessaggio());
					m.setContenutoMessaggio(messaggio.getContenutoMessaggio());
					m.setPersonaD(messaggio.getPersonaD());
					m.setPersonaM(messaggio.getPersonaM());
					return repository.save(m);
		}).orElseGet(() -> {
			messaggio.setIdMessaggio(id);
			return repository.save(messaggio);
		});
		}
	
		@DeleteMapping("/messaggi/{id_messaggio}")
		public void elimina(@PathVariable Integer id) {
			repository.delete(repository.findById(id).orElseThrow(() -> new NotFoundException()));
		}
}
