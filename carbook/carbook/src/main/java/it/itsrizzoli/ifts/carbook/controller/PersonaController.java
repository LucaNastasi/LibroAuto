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

import it.itsrizzoli.ifts.carbook.model.Persona;
import it.itsrizzoli.ifts.carbook.repository.PersonaRepository;

@CrossOrigin(origins = "*")
@RestController
public class PersonaController {

	@Autowired
	private PersonaRepository repository; //proprietà
	
	@GetMapping("/persone")	//api
	public List<Persona> all() {
	return repository.findAll();
	}
	
	@GetMapping("/persone/{email}")	//api
	public Persona byEMAIL(@PathVariable String email) {
	return repository
			.findById(email)
			.orElseThrow();	
	}
	
	@PostMapping("/persone")	//api
	public Persona inserisci(@RequestBody Persona persona) {
		return repository.save(persona);
	}
	
	@PutMapping("/persone/{email}") //api
	public Persona aggiorna(@RequestBody Persona persona, @PathVariable String email)  {
			repository
				.findById(email)
				.ifPresentOrElse((p) -> {
					p.setNome(p.getNome());
					p.setCognome(p.getCognome());
					//p.setEmail(p.getEmail());
					p.setPassword(p.getPassword());
					p.setUsername(p.getUsername());
					repository.save(p);
				}, () -> {
					repository.save(persona);
				});
		return repository.findById(email).get();	}
	
		@DeleteMapping("/persone/{email}")
		public void elimina( @PathVariable String email) {
			repository.deleteById(email);
		}
}

