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
	@Column(length = 20)
	private Integer idCommento; 
	
	private byte[] mediaCommento;
	
	@Column(length = 1000)
	private String testoCommento;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date DataOracommento;
	

	
	
	
	public Integer getIdCommento() {
		return idCommento;
	}

	public void setIdCommento(Integer idCommento) {
		this.idCommento = idCommento;
	}

	public byte[] getMediaCommento() {
		return mediaCommento;
	}

	public void setMediaCommento(byte[] mediaCommento) {
		this.mediaCommento = mediaCommento;
	}

	public String getTestoCommento() {
		return testoCommento;
	}

	public void setTestoCommento(String testoCommento) {
		this.testoCommento = testoCommento;
	}

	public Date getDataOracommento() {
		return DataOracommento;
	}

	public void setDataOracommento(Date dataOracommento) {
		DataOracommento = dataOracommento;
	}

	public Pubblicazione getPubblicazione() {
		return pubblicazione;
	}

	public void setPubblicazione(Pubblicazione pubblicazione) {
		this.pubblicazione = pubblicazione;
	}

	@ManyToOne (cascade = CascadeType.ALL) 
	private Pubblicazione pubblicazione;





	@Override
	public String toString() {
		return "Commento [idCommento=" + idCommento + ", mediaCommento=" + Arrays.toString(mediaCommento)
				+ ", testoCommento=" + testoCommento + ", DataOracommento=" + DataOracommento + ", pubblicazione="
				+ pubblicazione + "]";
	}
	

	

	}
