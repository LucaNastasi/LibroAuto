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

import it.itsrizzoli.ifts.carbook.model.Commento;
import it.itsrizzoli.ifts.carbook.repository.CommentoRepository;

@RestController
public class CommentoController {

	@Autowired
	private CommentoRepository repository; //proprietà
	
	@GetMapping("/commenti")	//api
	public List<Commento> all() {
	return repository.findAll();
	}
	
	@GetMapping("/commenti/{id_commento}")	//api
	public Commento byID(@PathVariable String id_commento) {
	return repository
			.findById(id_commento)
			.orElseThrow();	
	}
	
	@PostMapping("/commenti")	//api
	public Commento inserisci(@RequestBody Commento commento) {
		return repository.save(commento);
	}
	
	@PutMapping("/commenti/{id_commento}") //api
	public Commento aggiorna(@RequestBody Commento commento, @PathVariable String id_commento)  {
			repository
				.findById(id_commento)
				.ifPresentOrElse((c) -> {
				c.setContenutoCommento(c.getContenutoCommento());
			//	c.setMediaCommento(c.getMediaCommento());
				c.setDataOracommento(c.getDataOracommento());
					repository.save(c);
				}, () -> {
					repository.save(commento);
				});
		return repository.findById(id_commento).get();	}
	
		@DeleteMapping("/commenti/{id_commento}")
		public void elimina( @PathVariable String id_commento) {
			repository.deleteById(id_commento);
		}
}

