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
import it.itsrizzoli.ifts.carbook.model.Commento;
import it.itsrizzoli.ifts.carbook.repository.CommentoRepository;

@RestController
public class CommentoController {

	@Autowired
	private CommentoRepository repository; // proprietà

	@GetMapping("/commenti") // api
	public List<Commento> all() {
		return repository.findAll();
	}

	@GetMapping("/commenti/{id}") // api
	public Commento byID(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException());

	}

	@PostMapping("/commenti") // api
	public Commento inserisci(@RequestBody Commento commento) {
		return repository.save(commento);
	}

	@PutMapping("/commenti/{id}") // api
	public Commento aggiorna(@RequestBody Commento commento, @PathVariable Integer id) {
		return repository.findById(id).map(c -> {
			c.setTestoCommento(commento.getTestoCommento());
			c.setMediaCommento(commento.getMediaCommento());
			c.setDataOracommento(commento.getDataOracommento());
			c.setMiPiace(commento.getMiPiace());
			c.setPersona(commento.getPersona());
			c.setPubblicazione(commento.getPubblicazione());

			return repository.save(c);
		}).orElseGet(() -> {
			commento.setIdCommento(id);
			return repository.save(commento);
		});
	}

	@DeleteMapping("/commenti/{id}")
	public void elimina(@PathVariable Integer id) {
		repository.delete(repository.findById(id).orElseThrow(() -> new NotFoundException()));
	}
}
