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
public class Immagine {
public Immagine() {
	super();
}
public Immagine( byte[] picByte) {

	this.picByte = picByte;
}
@Id
@Column(name = "idImmagine")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name = "picByte", length = 1000)
private byte[] picByte;

public byte[] getPicByte() {
	return picByte;
}

public void setPicByte(byte[] picByte) {
	this.picByte = picByte;
}
}