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
	
	@GetMapping("/eventi/{id}")	//api
	public Evento byID(@PathVariable Integer id) {
			return repository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	@PostMapping("/eventi")	//api
	public Evento inserisci(@RequestBody Evento evento) {
		return repository.save(evento);
	}
	
	@PutMapping("/eventi/{id}") //api
	public Evento aggiorna(@RequestBody Evento evento, @PathVariable Integer id) {
		return repository.findById(id).map(e ->{
			e.setNomeEvento(evento.getNomeEvento());
			e.setDescrizione(evento.getDescrizione());
			e.setDataEvento(evento.getDataEvento());
			e.setLuogo(evento.getLuogo());
			e.setPersona(evento.getPersona());
			e.setPubblicazioni(evento.getPubblicazioni());
			
			return repository.save(e);
		}).orElseGet(()->{
			evento.setIdEvento(id);
			return repository.save(evento);
		});
	}
		@DeleteMapping("/eventi/{id}")
		public void elimina( @PathVariable Integer id) {
			repository.delete(repository.findById(id).orElseThrow(() -> new NotFoundException()));
		}
}