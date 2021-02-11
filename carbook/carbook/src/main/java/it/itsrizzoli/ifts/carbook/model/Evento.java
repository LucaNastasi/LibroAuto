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
		property = "codEvento"
		)
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_evento", length = 20)
	private Integer codEvento; 
	
	@Column(name = "email_creatore", length = 40)
	private String emailCreatore;
	
	@Column(name = "email_partecipante", length = 40)
	private String emailPartecipante;
	
	@Column( length = 50)
	private String nome;
	
	@Column(length = 50)
	private String luogo;
	
	@Column(name = "num_partecipanti", length = 50)
	private String numPartecipanti;
	
	@Column(length = 1000)
private String descrizione;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_ora_evento", nullable = false)
	private Date DataOraEvento;
	
//	@Column(length = 1000)
//	private byte[] media_commento;
	
	@ManyToOne(cascade = CascadeType.ALL) 
	private Persona persona;
	
	public Integer getcodEvento() {
		return codEvento;
	}

	public void setcodEvento(Integer codEvento) {
		this.codEvento = codEvento;
	}

	public Integer getCodEvento() {
		return codEvento;
	}

	public void setCodEvento(Integer codEvento) {
		this.codEvento = codEvento;
	}

	public String getEmailCreatore() {
		return emailCreatore;
	}

	public void setEmailCreatore(String emailCreatore) {
		this.emailCreatore = emailCreatore;
	}

	public String getEmailPartecipante() {
		return emailPartecipante;
	}

	public void setEmailPartecipante(String emailPartecipante) {
		this.emailPartecipante = emailPartecipante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getNumPartecipanti() {
		return numPartecipanti;
	}

	public void setNumPartecipanti(String num_partecipanti) {
		this.numPartecipanti = num_partecipanti;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getDataOraEvento() {
		return DataOraEvento;
	}

	public void setDataOraEvento(Date dataOraEvento) {
		DataOraEvento = dataOraEvento;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Evento [codEvento=" + codEvento + ", email_creatore=" + emailCreatore + ", email_partecipante="
				+ emailPartecipante + ", nome=" + nome + ", luogo=" + luogo + ", num_partecipanti=" + numPartecipanti
				+ ", descrizione=" + descrizione + ", DataOraEvento=" + DataOraEvento + ", persona=" + persona + "]";
	}
	
}
	
