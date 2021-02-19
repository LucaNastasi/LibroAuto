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
		property = "idMessaggio"
		)
public class Messaggio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMessaggio; 
	
	@Column(length = 1000)
	private String contenutoMessaggio;
	
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date DataOraMessaggio;
	
	
	@ManyToOne(cascade = CascadeType.ALL) 
	private Persona personaM;
	
	@ManyToOne(cascade = CascadeType.ALL) 
	private Persona personaD;


	public Integer getIdMessaggio() {
		return idMessaggio;
	}


	public void setIdMessaggio(Integer idMessaggio) {
		this.idMessaggio = idMessaggio;
	}

	public String getContenutoMessaggio() {
		return contenutoMessaggio;
	}


	public void setContenutoMessaggio(String contenutoMessaggio) {
		this.contenutoMessaggio = contenutoMessaggio;
	}


	public Date getDataOraMessaggio() {
		return DataOraMessaggio;
	}


	public void setDataOraMessaggio(Date dataOraMessaggio) {
		DataOraMessaggio = dataOraMessaggio;
	}


	public Persona getPersonaM() {
		return personaM;
	}


	public void setPersonaM(Persona personaM) {
		this.personaM = personaM;
	}


	public Persona getPersonaD() {
		return personaD;
	}


	public void setPersonaD(Persona personaD) {
		this.personaD = personaD;
	}


	@Override
	public String toString() {
		return "Messaggio [idMessaggio=" + idMessaggio + ", contenutoMessaggio=" + contenutoMessaggio
				+ ", DataOraMessaggio=" + DataOraMessaggio + ", personaM=" + personaM + ", personaD=" + personaD + "]";
	}







}
	