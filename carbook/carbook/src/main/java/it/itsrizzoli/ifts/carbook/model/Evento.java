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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idEvento"
		)
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer idEvento; 

	
	@Column(nullable = false, length = 50)
	private String nomeEvento;
	
	@Column(nullable = false, length = 50)
	private String luogo;
	
	@Column(length = 1000)
	private String descrizione;
	
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataEvento;
	
	@ManyToOne(cascade = CascadeType.ALL) 
	private Persona persona;
	
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private List<Pubblicazione> pubblicazioni;

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public List<Pubblicazione> getPubblicazioni() {
		return pubblicazioni;
	}

	public void setPubblicazioni(List<Pubblicazione> pubblicazioni) {
		this.pubblicazioni = pubblicazioni;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nomeEvento=" + nomeEvento + ", luogo=" + luogo + ", descrizione="
				+ descrizione + ", dataEvento=" + dataEvento + ", persona=" + persona + ", pubblicazioni="
				+ pubblicazioni + ", getIdEvento()=" + getIdEvento() + ", getNomeEvento()=" + getNomeEvento()
				+ ", getLuogo()=" + getLuogo() + ", getDescrizione()=" + getDescrizione() + ", getDataEvento()="
				+ getDataEvento() + ", getPersona()=" + getPersona() + ", getPubblicazioni()=" + getPubblicazioni()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	

	
}
	
