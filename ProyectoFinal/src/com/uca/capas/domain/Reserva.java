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
@Table(schema="public" , name="reserva")


public class Reserva {
	
	@Id
	@GeneratedValue(generator="reserva_id_reserva_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="reserva_id_reserva_seq",sequenceName="public.reserva_id_reserva_seq",allocationSize = 1)
	
	@Column(name="id_reserva")
	private Integer cReserva;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pelicula")
	private Movie pelicula;

	public Integer getcReserva() {
		return cReserva;
	}

	public void setcReserva(Integer cReserva) {
		this.cReserva = cReserva;
	}

	public Movie getPelicula() {
		return pelicula;
	}

	public void setPelicula(Movie pelicula) {
		this.pelicula = pelicula;
	}

	public Reserva(Integer cReserva, Movie pelicula) {
		super();
		this.cReserva = cReserva;
		this.pelicula = pelicula;
	}

	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
