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
import it.itsrizzoli.ifts.carbook.model.MiPiace;
import it.itsrizzoli.ifts.carbook.repository.MiPiaceRepository;

@RestController
public class MiPiaceController {

	@Autowired
	private MiPiaceRepository repository;

	@GetMapping("/miPiace")
	public List<MiPiace> all() {
		return repository.findAll();
	}

	@GetMapping("/miPiace/{id}")
	public MiPiace byID(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException());

	}

	@PostMapping("/miPiace")
	public MiPiace inserisci(@RequestBody MiPiace miPiace) {
		return repository.save(miPiace);
	}

	@PutMapping("/miPiace/{id}") // api
	public MiPiace aggiorna(@RequestBody MiPiace miPiace, @PathVariable Integer id) {
		return repository.findById(id).map(l -> {
			l.setPersona(miPiace.getPersona());
			l.setCommento(miPiace.getCommento());
			l.setPubblicazione(miPiace.getPubblicazione());

			return repository.save(l);
		}).orElseGet(() -> {
			miPiace.setidMiPiace(id);
			return repository.save(miPiace);
		});
	}

	@DeleteMapping("/miPiace/{id}")
	public void elimina(@PathVariable Integer id) {
		repository.delete(repository.findById(id).orElseThrow(() -> new NotFoundException()));

	}

}
