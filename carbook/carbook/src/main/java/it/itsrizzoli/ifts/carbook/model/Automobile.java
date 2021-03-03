package it.itsrizzoli.ifts.carbook.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idAutomobile"
		
		)
public class Automobile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer idAutomobile; 
	
	@Column(nullable = false, length = 100)
	private String Modello ;
	
	@Column(nullable = false, length = 100)
	private String Colore;
	
	@Column(nullable = false, length = 100)
	private String Stato;
	
	@Column(nullable = false, length = 100)
	private Integer Chilometri;
	
	@Column(nullable = false, length = 100)
	private String Alimentazione;
	
	@Column(nullable = false, length = 100)
	private Integer Cavalli;
	
	@Column(nullable = false, length = 100)
	private byte[] fotoAuto;
	
	@Column(nullable = false, length = 100)
	private Integer Prezzo;
	
	

	@OneToMany(mappedBy = "automobile", cascade = CascadeType.ALL)
	private List<Pubblicazione> pubblicazioni;
		
	
	
	

	public Integer getIdAutomobile() {
		return idAutomobile;
	}

	public void setIdAutomobile(Integer idAutomobile) {
		this.idAutomobile = idAutomobile;
	}

	public String getModello() {
		return Modello;
	}

	public void setModello(String modello) {
		Modello = modello;
	}

	public String getColore() {
		return Colore;
	}

	public void setColore(String colore) {
		Colore = colore;
	}

	public String getStato() {
		return Stato;
	}

	public void setStato(String stato) {
		Stato = stato;
	}

	public Integer getChilometri() {
		return Chilometri;
	}

	public void setChilometri(Integer chilometri) {
		Chilometri = chilometri;
	}

	public String getAlimentazione() {
		return Alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		Alimentazione = alimentazione;
	}

	public Integer getCavalli() {
		return Cavalli;
	}

	public void setCavalli(Integer cavalli) {
		Cavalli = cavalli;
	}

	public byte[] getFotoAuto() {
		return fotoAuto;
	}

	public void setFotoAuto(byte[] fotoAuto) {
		this.fotoAuto = fotoAuto;
	}

	public Integer getPrezzo() {
		return Prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		Prezzo = prezzo;
	}

	public List<Pubblicazione> getPubblicazioni() {
		return pubblicazioni;
	}

	public void setPubblicazioni(List<Pubblicazione> pubblicazioni) {
		this.pubblicazioni = pubblicazioni;
	}

	@Override
	public String toString() {
		return "Automobile [idAutomobile=" + idAutomobile + ", Modello=" + Modello + ", Colore=" + Colore + ", Stato="
				+ Stato + ", Chilometri=" + Chilometri + ", Alimentazione=" + Alimentazione + ", Cavalli=" + Cavalli
				+ ", fotoAuto=" + Arrays.toString(fotoAuto) + ", Prezzo=" + Prezzo + ", pubblicazioni=" + pubblicazioni
				+ "]";
	}



	
}
