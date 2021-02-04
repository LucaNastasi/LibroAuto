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
		property = "email"
		
		)
public class Persona {

	@Id
	private String email;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false, length = 100)
	private String cognome;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascita", nullable = false) 
	private Date dataNascita;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 100)
	private String citta;
	
	@Column(nullable = false, length = 100)
	private String username;

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	private List<Post> posts;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	private List<Commento> commenti;
	
//	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
//	private List<Messaggio> messaggiD;
//	
//	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
//	private List<Messaggio> messaggiM;

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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	@Override
	public String toString() {
		return "Persona [email=" + email + ", nome=" + nome + ", cognome=" + cognome + ", data_nascita=" + dataNascita
				+ ", password=" + password + ", citta=" + citta + ", username=" + username + "]";
	}

//	public List<Messaggio> getMessaggiD() {
//		return messaggiD;
//	}
//
//	public void setMessaggiD(List<Messaggio> messaggiD) {
//		this.messaggiD = messaggiD;
//	}
//
//	public List<Messaggio> getMessaggiM() {
//		return messaggiM;
//	}
//
//	public void setMessaggiM(List<Messaggio> messaggiM) {
//		this.messaggiM = messaggiM;
//	} 



	
}
