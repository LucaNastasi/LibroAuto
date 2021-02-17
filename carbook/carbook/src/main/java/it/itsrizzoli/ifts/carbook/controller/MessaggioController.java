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

import it.itsrizzoli.ifts.carbook.model.Messaggio;
import it.itsrizzoli.ifts.carbook.repository.MessaggioRepository;

@RestController
public class MessaggioController {

	@Autowired
	private MessaggioRepository repository; //proprietà
	
	@GetMapping("/messaggiM")	//api
	public List<Messaggio> all() {
	return repository.findAll();
	}
	
	@GetMapping("/messaggiD")	//api
	public List<Messaggio> all1() {
	return repository.findAll();
	}
	
	@GetMapping("/messaggi/{id_messaggio}")	//api
	public Messaggio byIDMSSGG(@PathVariable String id_messaggio) {
	return repository
			.findById(id_messaggio)
			.orElseThrow();	
	}
	
	@PostMapping("/messaggi")	//api
	public Messaggio inserisci(@RequestBody Messaggio messaggio) {
		return repository.save(messaggio);
	}
	
	@PutMapping("/messaggi/{id_messaggio}") //api
	public Messaggio aggiorna(@RequestBody Messaggio messaggio, @PathVariable String id_messaggio)  {
			repository
				.findById(id_messaggio)
				.ifPresentOrElse((m) -> {
//					m.setPersonaEmailDestinatario(m.getPersonaEmailDestinatario());
//					m.setPersonaEmailMittente(m.getPersonaEmailMittente());
					m.setContenutoMessaggio(m.getContenutoMessaggio());
					m.setDataOraMessaggio(m.getDataOraMessaggio());
					repository.save(m);
				}, () -> {
					repository.save(messaggio);
				});
		return repository.findById(id_messaggio).get();	}
	
		@DeleteMapping("/messaggi/{id_messaggio}")
		public void elimina( @PathVariable String id_messaggio) {
			repository.deleteById(id_messaggio);
		}
}
