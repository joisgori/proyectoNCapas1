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
@Table(schema="public" , name="tipopelicula")


public class TipoPelicula {
	
	@Id
	@GeneratedValue(generator="tipopelicula_id_tipopeli_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="tipopelicula_id_tipopeli_seq",sequenceName="public.tipopelicula_id_tipopeli_seq	",allocationSize = 1)
	@Column(name="id_tipopeli")
	private Integer cTipoP;
	
	@Column(name="tipo_pelicula")
	private String aTpeli;
	
	@OneToMany(mappedBy = "tipopelicula", fetch = FetchType.LAZY)
	private List<Movie> pelicula;

	public Integer getcTipoP() {
		return cTipoP;
	}

	public void setcTipoP(Integer cTipoP) {
		this.cTipoP = cTipoP;
	}

	public String getaTpeli() {
		return aTpeli;
	}

	public void setaTpeli(String aTpeli) {
		this.aTpeli = aTpeli;
	}

	public List<Movie> getPelicula() {
		return pelicula;
	}

	public void setPelicula(List<Movie> pelicula) {
		this.pelicula = pelicula;
	}

	public TipoPelicula(Integer cTipoP, String aTpeli, List<Movie> pelicula) {
		super();
		this.cTipoP = cTipoP;
		this.aTpeli = aTpeli;
		this.pelicula = pelicula;
	}

	public TipoPelicula() {
		super();
		// TODO Auto-generated constructor stub
	}

}
