package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public" , name="asiento")

public class Asiento {
	
	@Id
	@GeneratedValue(generator="asiento_id_asiento_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="asiento_id_asiento_seq",sequenceName="public.asiento_id_asiento_seq",allocationSize = 1)
	@Column(name="id_asiento")
	private Integer cAsiento;
	
	@Column(name="fila")
	private String aFila;
	
	@Column(name="columna")
	private String aColumna;

	@Column(name="estado_uso")
	private Boolean aEstado;
	
	@OneToMany(mappedBy = "asiento", fetch = FetchType.EAGER)
	private List<Reserva> reserva;
	
	@OneToMany(mappedBy = "asiento", fetch = FetchType.EAGER)
	private List<Sala> sala;

	
	
	

	public Asiento(Integer cAsiento, String aFila, String aColumna, Boolean aEstado, List<Reserva> reserva,
			List<Sala> sala) {
		super();
		this.cAsiento = cAsiento;
		this.aFila = aFila;
		this.aColumna = aColumna;
		this.aEstado = aEstado;
		this.reserva = reserva;
		this.sala = sala;
	}



	public Asiento() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getcAsiento() {
		return cAsiento;
	}

	public void setcAsiento(Integer cAsiento) {
		this.cAsiento = cAsiento;
	}

	public String getaFila() {
		return aFila;
	}

	public void setaFila(String aFila) {
		this.aFila = aFila;
	}

	public String getaColumna() {
		return aColumna;
	}

	public void setaColumna(String aColumna) {
		this.aColumna = aColumna;
	}

	public Boolean getaEstado() {
		return aEstado;
	}

	public void setaEstado(Boolean aEstado) {
		this.aEstado = aEstado;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}



	public List<Sala> getSala() {
		return sala;
	}


	public void setSala(List<Sala> sala) {
		this.sala = sala;
	}
	
	
}
