package it.itsrizzoli.ifts.carbook.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String email;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
//	@JsonIgnore
//	@ManyToMany(mappedBy = "autori", cascade = CascadeType.ALL)
//	private List<Libro> libri; //ha fatto pi� libri
//	
//	public void addLibro(Libro l) {
//		if (libri == null) {
//			libri = new ArrayList<>();
//		}
//		libri.add(l);
//		if (l.getAutori() == null) {
//			l.setAutori(new ArrayList<>());
//		}
//		l.getAutori().add(this);
//	}

	public String getemail() {
		return email;
	}

	public void setIdAutore(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public List<Libro> getLibri() {
//		return libri;
//	}
//
//	public void setLibri(List<Libro> libri) {
//		this.libri = libri;
//	}

	@Override
	public String toString() {
		return "Persona [email=" + email + ", nome=" + nome + ", post=" + post + "]";
	}
}
