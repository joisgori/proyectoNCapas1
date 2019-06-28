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
@Table(schema="public" , name="idiomas")


public class Idiomas {
	
	@Id
	@GeneratedValue(generator="idiomas_id_idioma_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="idiomas_id_idioma_seq",sequenceName="public.idiomas_id_idioma_seq", allocationSize = 1)
	@Column(name="id_idioma")
	private Integer cIdioma;
	
	@Column(name="idioma_peli")
	private String aIpeli;
	
	@OneToMany(mappedBy = "idiomas", fetch = FetchType.LAZY)
	private List<Movie> pelicula;

	public Idiomas(Integer cIdioma, String aIpeli) {
		super();
		this.cIdioma = cIdioma;
		this.aIpeli = aIpeli;
	}
	
	

	public Idiomas() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getcIdioma() {
		return cIdioma;
	}

	public void setcIdioma(Integer cIdioma) {
		this.cIdioma = cIdioma;
	}

	public String getaIpeli() {
		return aIpeli;
	}

	public void setaIpeli(String aIpeli) {
		this.aIpeli = aIpeli;
	}

	
}
