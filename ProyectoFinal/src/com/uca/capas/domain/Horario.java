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
@Table(schema="public" , name="horario")


public class Horario {
	
	@Id
	@GeneratedValue(generator="horario_id_horario_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="horario_id_horario_seq",sequenceName="public.horario_id_horario_seq",allocationSize = 1)
	@Column(name="id_horario")
	private Integer cHorario;
	
	@Column(name="horario_peli")
	private String aHpeli;
	
	@OneToMany(mappedBy = "horario", fetch = FetchType.LAZY)
	private List<Movie> pelicula;

	public Horario(Integer cHorario, String aHpeli) {
		super();
		this.cHorario = cHorario;
		this.aHpeli = aHpeli;
	}
	
	

	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getcHorario() {
		return cHorario;
	}

	public void setcHorario(Integer cHorario) {
		this.cHorario = cHorario;
	}

	public String getaHpeli() {
		return aHpeli;
	}

	public void setaHpeli(String aHpeli) {
		this.aHpeli = aHpeli;
	}


	
}
