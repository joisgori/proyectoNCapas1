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
@Table(schema="public" , name="genero")


public class Genero {
	
	@Id
	@GeneratedValue(generator="genero_id_genero_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="genero_id_genero_seq",sequenceName="public.genero_id_genero_seq",allocationSize = 1)
	@Column(name="id_genero")
	private Integer cGenero;
	
	@Column(name="genero_peli")
	private String aGpeli;
	
	@OneToMany(mappedBy = "genero", fetch = FetchType.LAZY)
	private List<Movie> pelicula;
	
	public Genero(Integer cGenero, String aGpeli) {
		super();
		this.cGenero = cGenero;
		this.aGpeli = aGpeli;
	}
	
	
	
	public Genero() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getcGenero() {
		return cGenero;
	}

	public void setcGenero(Integer cGenero) {
		this.cGenero = cGenero;
	}

	public String getaGpeli() {
		return aGpeli;
	}

	public void setaGpeli(String aGpeli) {
		this.aGpeli = aGpeli;
	}

}
