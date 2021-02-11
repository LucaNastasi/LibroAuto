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

import it.itsrizzoli.ifts.carbook.model.Evento;
import it.itsrizzoli.ifts.carbook.repository.EventoRepository;

@RestController
public class EventoController {

	@Autowired
	private EventoRepository repository; //proprietà
	
	@GetMapping("/eventi")	//api
	public List<Evento> all() {
	return repository.findAll();
	}
	
	@GetMapping("/eventi/{codEvento}")	//api
	public Evento byID(@PathVariable String cod_evento) {
	return repository
			.findById(cod_evento)
			.orElseThrow();	
	}
	
	@PostMapping("/eventi")	//api
	public Evento inserisci(@RequestBody Evento evento) {
		return repository.save(evento);
	}
	
	@PutMapping("/eventi/{cod_evento}") //api
	public Evento aggiorna(@RequestBody Evento evento, @PathVariable String cod_evento)  {
			repository
				.findById(cod_evento)
				.ifPresentOrElse((e) -> {
					
		
					repository.save(e);
				}, () -> {
					repository.save(evento);
				});
		return repository.findById(cod_evento).get();	}
	
		@DeleteMapping("/eventi/{cod_evento}")
		public void elimina( @PathVariable String cod_evento) {
			repository.deleteById(cod_evento);
		}
}