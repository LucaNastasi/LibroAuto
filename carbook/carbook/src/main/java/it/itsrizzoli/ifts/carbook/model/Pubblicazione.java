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
		property = "idPubblicazione"
		
		)
public class Pubblicazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPubblicazione; 
	
	@Column(length = 1000)
	private String descrizione;
	
	
	//private byte[] media; 
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataPubblicazione;
	
	@ManyToOne(cascade = CascadeType.ALL) 
	private Persona persona;
	
	
	@ManyToOne (cascade = CascadeType.ALL)
	private Automobile automobile;


	public Integer getIdPubblicazione() {
		return idPubblicazione;
	}


	public void setIdPubblicazione(Integer idPubblicazione) {
		this.idPubblicazione = idPubblicazione;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}


	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public Automobile getAutomobile() {
		return automobile;
	}


	public void setAutomobile(Automobile automobile) {
		this.automobile = automobile;
	}


	@Override
	public String toString() {
		return "Pubblicazione [idPubblicazione=" + idPubblicazione + ", descrizione=" + descrizione
				+ ", dataPubblicazione=" + dataPubblicazione + ", persona=" + persona + ", automobile=" + automobile
				+ "]";
	}

	
}
