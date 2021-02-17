package it.itsrizzoli.ifts.carbook.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
			
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idPost"
		
		)
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_post", length = 20)
	private Integer idPost; 
	
	@Column(name = "cod_evento", length = 200)
	private Integer codEvento;
	
	
	
//	@Column(name = "persona_email", length = 40)
//	private String personaEmail;
	
	@Column(length = 1000)
	private String descrizione;
	
	@Column(length = 1000)
	private byte[] media; 
	
	@ManyToOne(cascade = CascadeType.ALL) 
	private Persona persona;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Commento> commenti;

	public Integer getIdPost() {
		return idPost;
	}

	public void setIdPost(Integer id_post) {
		this.idPost = id_post;
	}

	public Integer getCodEvento() {
		return codEvento;
	}

	public void setCodEvento(Integer cod_evento) {
		this.codEvento = cod_evento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public byte[] getMedia() {
		return media;
	}

	public void setMedia(byte[] media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "Post [idPost=" + idPost + ", codEvento=" + codEvento + ", descrizione=" + descrizione + ", media="
				+ Arrays.toString(media) + ", persona=" + persona + ", commenti=" + commenti + "]";
	}
	
}
