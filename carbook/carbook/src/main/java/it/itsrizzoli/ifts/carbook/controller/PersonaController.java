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

import it.itsrizzoli.ifts.carbook.exceptions.NotFoundException;
import it.itsrizzoli.ifts.carbook.model.Persona;
import it.itsrizzoli.ifts.carbook.repository.PersonaRepository;

@CrossOrigin(origins = "*")
@RestController
public class PersonaController {

	@Autowired
	private PersonaRepository repository; // proprietà

	@GetMapping("/persone") // api
	public List<Persona> all() {
		return repository.findAll();
	}

	@GetMapping("/persone/{id}") // api
	public Persona byID(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	@PostMapping("/persone") // api
	public Persona inserisci(@RequestBody Persona persona) {
		return repository.save(persona);
	}

	@PutMapping("/persone/{id}") // api
	public Persona aggiorna(@RequestBody Persona persona, @PathVariable Integer id) {
		return repository.findById(id).map(p -> {
			p.setNome(persona.getNome());
			p.setCognome(persona.getCognome());
			p.setEmail(persona.getEmail());
			p.setPassword(persona.getPassword());
			p.setUsername(persona.getUsername());
			p.setCitta(persona.getCitta());
			p.setTelefono(persona.getTelefono());
					p.setPubblicazioni(persona.getPubblicazioni());
 
			return repository.save(p);
		}).orElseGet(() -> {
			persona.setId(id);
			return repository.save(persona);
		});
	}

	@DeleteMapping("/persone/{id}")
	public void elimina(@PathVariable Integer id) {
		repository.delete(repository.findById(id).orElseThrow(() -> new NotFoundException()));
	}
}
