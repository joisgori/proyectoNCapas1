package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public" , name="salaxpelicula")


public class SxP {
	
	@Id
	@GeneratedValue(generator="salaxpelicula_id_salaxpelicula_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="salaxpelicula_id_salaxpelicula_seq",sequenceName="public.salaxpelicula_id_salaxpelicula_seq",allocationSize = 1)
	@Column(name="id_salaxpelicula")
	private Integer cSxP;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pelicula")
	private Movie pelicula;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sala")
	private Sala sala;
	
	
	public SxP(Integer cSxP, Movie pelicula, Sala sala) {
		super();
		this.cSxP = cSxP;
		this.pelicula = pelicula;
		this.sala = sala;
	}


	public Integer getcSxP() {
		return cSxP;
	}


	public void setcSxP(Integer cSxP) {
		this.cSxP = cSxP;
	}


	public SxP() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Movie getPelicula() {
		return pelicula;
	}

	public void setPelicula(Movie pelicula) {
		this.pelicula = pelicula;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	

}
