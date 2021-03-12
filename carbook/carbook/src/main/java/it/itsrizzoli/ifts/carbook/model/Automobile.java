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
	private String modello ;
	
	@Column(nullable = false, length = 100)
	private String annoImmatricolazione;
	
	@Column(nullable = false, length = 100)
	private String stato;
	
	@Column(nullable = false, length = 100)
	private Integer chilometraggio;
	
	@Column(nullable = false, length = 100)
	private String alimentazione;
	
	@Column(nullable = false, length = 100)
	private String cambio;
	
	@Column(nullable = false, length = 100)
	private String marca;
	
	@Column(nullable = false, length = 100)
	private String citta;
	
	@Column(nullable = false, length = 100)
	private Integer potenza;
	
	@Column(length = 1000)
	private String fotoAuto;
	
	@Column(nullable = false, length = 100)
	private Integer costo;

	@OneToMany(mappedBy = "automobile", cascade = CascadeType.ALL)
	private List<Pubblicazione> pubblicazioni;

	public Integer getIdAutomobile() {
		return idAutomobile;
	}

	public void setIdAutomobile(Integer idAutomobile) {
		this.idAutomobile = idAutomobile;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}

	public void setAnnoImmatricolazione(String annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Integer getChilometraggio() {
		return chilometraggio;
	}

	public void setChilometraggio(Integer chilometraggio) {
		this.chilometraggio = chilometraggio;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public Integer getPotenza() {
		return potenza;
	}

	public void setPotenza(Integer potenza) {
		this.potenza = potenza;
	}

	public String getFotoAuto() {
		return fotoAuto;
	}

	public void setFotoAuto(String fotoAuto) {
		this.fotoAuto = fotoAuto;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public List<Pubblicazione> getPubblicazioni() {
		return pubblicazioni;
	}

	public void setPubblicazioni(List<Pubblicazione> pubblicazioni) {
		this.pubblicazioni = pubblicazioni;
	}

	@Override
	public String toString() {
		return "Automobile [idAutomobile=" + idAutomobile + ", modello=" + modello + ", annoImmatricolazione="
				+ annoImmatricolazione + ", stato=" + stato + ", chilometraggio=" + chilometraggio + ", alimentazione="
				+ alimentazione + ", cambio=" + cambio + ", marca=" + marca + ", citta=" + citta + ", potenza="
				+ potenza + ", fotoAuto=" + fotoAuto + ", costo=" + costo + ", pubblicazioni=" + pubblicazioni + "]";
	}
	

}

