package it.itsrizzoli.ifts.carbook.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.v3.oas.models.media.MediaType;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idCommento"
		)
public class Commento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_commento", length = 20)
	private Integer idCommento; 
	
	@Column(name = "media_commento", length = 200)
	private String mediaCommento;
	
	@Column(name = "contenuto_commento", length = 1000)
	private String contenutoCommento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_ora_commento", nullable = false)
	private Date DataOracommento;
	
//	@Column(length = 1000)
//	private byte[] media_commento;
	
	@ManyToOne(cascade = CascadeType.ALL) 
	private Persona persona;
	
	@ManyToOne (cascade = CascadeType.ALL) 
	private Post post;

	public Integer getIdCommento() {
		return idCommento;
	}

	public void setIdCommento(Integer idCommento) {
		this.idCommento = idCommento;
	}

//	public String getMediaCommento() {
//		return mediaCommento;
//	}
//
//	public void setMediaCommento(String mediaCommento) {
//		this.mediaCommento = mediaCommento;
//	}

	public String getContenutoCommento() {
		return contenutoCommento;
	}

	public void setContenutoCommento(String contenutoCommento) {
		this.contenutoCommento = contenutoCommento;
	}

	public Date getDataOracommento() {
		return DataOracommento;
	}

	public void setDataOracommento(Date data_ora_commento) {
		DataOracommento = data_ora_commento;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Commento [idCommento=" + idCommento + ", mediaCommento=" + mediaCommento + ", commentoContenuto="
				+ contenutoCommento + ", DataOracommento=" + DataOracommento + ", persona=" + persona + "]";
	}

	}
