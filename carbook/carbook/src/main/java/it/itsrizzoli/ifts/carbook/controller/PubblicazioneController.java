package it.itsrizzoli.ifts.carbook.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import it.itsrizzoli.ifts.carbook.model.Pubblicazione;
import it.itsrizzoli.ifts.carbook.repository.PubblicazioneRepository;

@CrossOrigin(origins = "*")
@RestController
public class PubblicazioneController {

	@Autowired
	private PubblicazioneRepository repository; // proprietà
	

	@GetMapping("/pubblicazioni") // api
	public List<Pubblicazione> all() {
		return repository.findAll();
	}
	@GetMapping("/pubblicazioni/persona/{persona}")
	public List<Pubblicazione> byPersona(@PathVariable Persona persona){
		return repository.byPersona(persona);
	}

	@GetMapping("/pubblicazioni/{id}")
	public Pubblicazione byID(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	@GetMapping("/listaPubllicazioni")
	public ArrayList<HashMap<String, String>> listaPubllicazione () {
		//HASHMAP E COME UNA PUBBLICAZIONE, FAI UN ARRAYLIST DI HASHMAP (E COME FARE UN ARRAYLIST DI PUBBLICAZIONI)
		ArrayList<HashMap<String, String>> risposta = new ArrayList<HashMap<String,String>>();
		
		List<Pubblicazione> listaPubblicazioni = repository.findAll();
		for (Pubblicazione p : listaPubblicazioni) {
			HashMap<String, String> pubblicazione = new HashMap<String, String>();
			//AGGIUNGERE TUTTIE LE COLLONE CHE TI SERVONO
			pubblicazione.put("marca", p.getAutomobile().getMarca());
			pubblicazione.put("modello", p.getAutomobile().getModello());
			pubblicazione.put("costo", p.getAutomobile().getCosto().toString());
			pubblicazione.put("chilometraggio", p.getAutomobile().getChilometraggio().toString());
			pubblicazione.put("dataPubblicazione", p.getDataPubblicazione().toString());
			pubblicazione.put("potenza", p.getAutomobile().getPotenza().toString());
			pubblicazione.put("stato", p.getAutomobile().getStato());
			pubblicazione.put("username", p.getPersona().getUsername());
			pubblicazione.put("telefono", p.getPersona().getTelefono());
			pubblicazione.put("alimentazione", p.getAutomobile().getAlimentazione());
			
			
			risposta.add(pubblicazione);
		}
		return risposta;
	}

	@PostMapping("/pubblicazioni") // api
	public Pubblicazione inserisci(@RequestBody Pubblicazione pubblicazione) {
		
		return repository.save(pubblicazione);
	}
	
	@PutMapping("/pubblicazioni/{idPubblicazione}") // api
	public Pubblicazione aggiorna( Pubblicazione pubblicazione, @PathVariable Integer id) {
		return repository.findById(id).map(pu -> {

			pu.setAutomobile(pubblicazione.getAutomobile());
			pu.setPersona(pubblicazione.getPersona());
			pu.setDescrizione(pubblicazione.getDescrizione());
			pu.setDataPubblicazione(pubblicazione.getDataPubblicazione());

			return repository.save(pu);
		}).orElseGet(() -> {
			pubblicazione.setIdPubblicazione(id);
			return repository.save(pubblicazione);
		});
	}

	@DeleteMapping("/pubblicazioni/{id}")
	public void elimina(@PathVariable Integer id) {
		repository.delete(repository.findById(id).orElseThrow(() -> new NotFoundException()));
	}
	
	@DeleteMapping("/pubblicazioni/")
	public void deleteAll() {
	 repository.deleteAll();

	} 

}
