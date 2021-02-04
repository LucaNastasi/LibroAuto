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

import it.itsrizzoli.ifts.carbook.model.Post;
import it.itsrizzoli.ifts.carbook.repository.PostRepository;

@RestController
public class PostController {

	@Autowired
	private PostRepository repository; //proprietà
	
	@GetMapping("/posts")	//api
	public List<Post> all() {
	return repository.findAll();
	}
	
	@GetMapping("/posts/{id_post}")	//api
	public Post byID(@PathVariable String id_post) {
	return repository
			.findById(id_post)
			.orElseThrow();	
	}
	
	@PostMapping("/posts")	//api
	public Post inserisci(@RequestBody Post post) {
		return repository.save(post);
	}
	
	@PutMapping("/posts/{id_post}") //api
	public Post aggiorna(@RequestBody Post post, @PathVariable String id_post)  {
			repository
				.findById(id_post)
				.ifPresentOrElse((po) -> {
				po.setCodEvento(po.getCodEvento());
				po.setDescrizione(po.getDescrizione());
				//po.setId_post(po.getId_post());
					repository.save(po);
				}, () -> {
					repository.save(post);
				});
		return repository.findById(id_post).get();	}
	
		@DeleteMapping("/posts/{id_post}")
		public void elimina( @PathVariable String id_post) {
			repository.deleteById(id_post);
		}
}

