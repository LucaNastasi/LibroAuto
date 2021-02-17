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
	@Column(name = "id_messaggio", length = 20)
	private Integer idMessaggio; 
	
	@Column(name = "persona_email_mittente", length = 40)
	private String PersonaEmailMittente;
	
	@Column(name = "persona_email_destinatario", length = 40)
	private String PersonaEmailDestinatario;
	
	@Column(name="contenuto_messaggio", length = 50)
	private String contenutoMessaggio;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_ora_messaggio", nullable = false)
	private Date DataOraMessaggio;
	
	
	@ManyToOne(cascade = CascadeType.ALL) 
	private Persona persona;


	public Integer getIdMessaggio() {
		return idMessaggio;
	}


	public void setIdMessaggio(Integer idMessaggio) {
		this.idMessaggio = idMessaggio;
	}


	public String getPersonaEmailMittente() {
		return PersonaEmailMittente;
	}


	public void setPersonaEmailMittente(String persona_email_mittente) {
		this.PersonaEmailMittente = persona_email_mittente;
	}


	public String getPersonaEmailDestinatario() {
		return PersonaEmailDestinatario;
	}


	public void setPersonaEmailDestinatario(String persona_email_destinatario) {
		this.PersonaEmailDestinatario = persona_email_destinatario;
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


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	@Override
	public String toString() {
		return "Messaggio [idMessaggio=" + idMessaggio + ", emailMittente=" + PersonaEmailMittente + ", emailDestinatario="
				+ PersonaEmailDestinatario + ", contenutoMessaggio=" + contenutoMessaggio + ", DataOraMessaggio="
				+ DataOraMessaggio + "]";
	}
	
}
	