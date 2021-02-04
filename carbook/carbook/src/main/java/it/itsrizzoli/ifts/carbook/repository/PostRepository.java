package it.itsrizzoli.ifts.carbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.itsrizzoli.ifts.carbook.model.Post;

public interface PostRepository extends JpaRepository<Post, String> {

}
