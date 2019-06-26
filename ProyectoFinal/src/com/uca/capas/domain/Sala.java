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
@Table(schema = "public", name = "sala")
public class Sala {
	
	@Id
	@GeneratedValue(generator="sala_id_sala_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="sala_id_sala_seq",sequenceName="public.sala_id_sala_seq",allocationSize = 1)
	@Column(name="id_sala")
	private Integer cSala;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_asiento")
	private Asiento asiento;

	@OneToMany(mappedBy = "sala", fetch = FetchType.EAGER)
	private List<SxP> salaxpelicula;
	
	@OneToMany(mappedBy = "sala", fetch = FetchType.EAGER)
	private List<Reserva> reserva;
	
	public Sala(Integer cSala) {
		super();
		this.cSala = cSala;
	}
	
	public Sala() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getcSala() {
		return cSala;
	}

	public void setcSala(Integer cSala) {
		this.cSala = cSala;
	}
	
	

}
