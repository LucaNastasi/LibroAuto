package it.itsrizzoli.ifts.carbook.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "idMiPiace"
		)
public class MiPiace {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMiPiace;
	
	@ManyToOne(cascade = CascadeType.ALL) 
	private Persona persona;
	
	@ManyToOne (cascade = CascadeType.ALL) 
	private Pubblicazione pubblicazione;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private Commento commento;

	public Integer getidMiPiace() {
		return idMiPiace;
	}

	public void setidMiPiace(Integer idMiPiace) {
		this.idMiPiace = idMiPiace;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Pubblicazione getPubblicazione() {
		return pubblicazione;
	}

	public void setPubblicazione(Pubblicazione pubblicazione) {
		this.pubblicazione = pubblicazione;
	}

	public Commento getCommento() {
		return commento;
	}

	public void setCommento(Commento commento) {
		this.commento = commento;
	}

	@Override
	public String toString() {
		return "MiPiace [idMiPiace=" + idMiPiace + ", persona=" + persona + ", pubblicazione=" + pubblicazione + ", commento="
				+ commento + "]";
	}

}
