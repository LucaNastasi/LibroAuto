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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id"
		
		)
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false, length = 100)
	private String cognome;
	

	@Column(nullable = false, length = 100)
	private String email;
	
	
	@Column(nullable = false, length = 100)
	private String username;

	
	@Column(nullable = false, length = 100)
	private String password;
	
	private byte[]fotoProfilo;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false) 
	private Date dataNascita;
	
	@Column(length = 100)
	private String citta;
	

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	private List<Pubblicazione> pubblicazioni;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	private List<Commento> commenti;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	private List<Evento> eventi;
	
	@OneToMany(mappedBy = "personaM", cascade = CascadeType.ALL)
	private List<Messaggio> messaggiM;
	
	@OneToMany(mappedBy = "personaD", cascade = CascadeType.ALL)
	private List<Messaggio> messaggiD;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	private List<MiPiace> miPiace;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date data_nascita) {
		this.dataNascita = data_nascita;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Pubblicazione> getPubblicazioni() {
		return pubblicazioni;
	}
	public void setPubblicazioni(List<Pubblicazione> pubblicazioni) {
		this.pubblicazioni = pubblicazioni;
	}

	public List<Commento> getCommenti() {
		return commenti;
	}

	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}

	public List<Messaggio> getMessaggiM() {
		return messaggiM;
	}

	public void setMessaggiM(List<Messaggio> messaggiM) {
		this.messaggiM = messaggiM;
	}

	public List<Messaggio> getMessaggiD() {
		return messaggiD;
	}

	public void setMessaggiD(List<Messaggio> messaggiD) {
		this.messaggiD = messaggiD;
	}

	public byte[] getFotoProfilo() {
		return fotoProfilo;
	}

	public void setFotoProfilo(byte[] fotoProfilo) {
		this.fotoProfilo = fotoProfilo;
	}
	public List<MiPiace> getMiPiace() {
		return miPiace;
	}

	public void setMiPiace(List<MiPiace> miPiace) {
		this.miPiace = miPiace;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", username="
				+ username + ", password=" + password + ", dataNascita=" + dataNascita + ", citta=" + citta
				+ ", pubblicazioni=" + pubblicazioni + ", commenti=" + commenti + ", eventi=" + eventi + ", messaggiM="
				+ messaggiM + ", messaggiD=" + messaggiD + "]";
	}

	
	
}
