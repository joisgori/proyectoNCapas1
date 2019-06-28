package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "sxp", fetch = FetchType.LAZY)
	private List<Movie> pelicula;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sala")
	private Sala sala;
	
	
	public SxP(Integer cSxP, Sala sala) {
		super();
		this.cSxP = cSxP;
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

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	

}
