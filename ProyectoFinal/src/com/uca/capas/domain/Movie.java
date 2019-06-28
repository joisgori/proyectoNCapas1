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
@Table(schema="public" , name="pelicula")
public class Movie {
	
	@Id
	@GeneratedValue(generator="pelicula_id_pelicula_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="pelicula_id_pelicula_seq",sequenceName="public.pelicula_id_pelicula_seq",allocationSize = 1)
	@Column(name="id_pelicula")
	private Integer cMovie;
	
	@Column(name="nombre_pelicula")
	private String pName;
	
	@Column(name="imagen_pelicula")
	private String pImage;
	
	@Column(name="duracion")
	private String pDuration;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_actores")
	private Actor actores;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipopeli")
	private TipoPelicula tipopelicula;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_genero")
	private Genero genero;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_idioma")
	private Idiomas idiomas;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_horario")
	private Horario horario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sxp")
	private SxP sxp;
		
	@OneToMany(mappedBy = "pelicula", fetch = FetchType.LAZY)
	private List<Reserva> reserva;
		
	public Movie(Integer cMovie, String pName, String pImage, String pDuration, Actor actores,
			TipoPelicula tipopelicula, Genero genero, Idiomas idiomas, Horario horario, SxP sxp,
			List<Reserva> reserva) {
		super();
		this.cMovie = cMovie;
		this.pName = pName;
		this.pImage = pImage;
		this.pDuration = pDuration;
		this.actores = actores;
		this.tipopelicula = tipopelicula;
		this.genero = genero;
		this.idiomas = idiomas;
		this.horario = horario;
		this.sxp = sxp;
		this.reserva = reserva;
	}
	
	public Integer getcMovie() {
		return cMovie;
	}






	public void setcMovie(Integer cMovie) {
		this.cMovie = cMovie;
	}






	public String getpName() {
		return pName;
	}






	public void setpName(String pName) {
		this.pName = pName;
	}






	public String getpImage() {
		return pImage;
	}






	public void setpImage(String pImage) {
		this.pImage = pImage;
	}






	public String getpDuration() {
		return pDuration;
	}






	public void setpDuration(String pDuration) {
		this.pDuration = pDuration;
	}






	public Actor getActores() {
		return actores;
	}






	public void setActores(Actor actores) {
		this.actores = actores;
	}






	public TipoPelicula getTipopelicula() {
		return tipopelicula;
	}






	public void setTipopelicula(TipoPelicula tipopelicula) {
		this.tipopelicula = tipopelicula;
	}






	public Genero getGenero() {
		return genero;
	}






	public void setGenero(Genero genero) {
		this.genero = genero;
	}






	public Idiomas getIdiomas() {
		return idiomas;
	}






	public void setIdiomas(Idiomas idiomas) {
		this.idiomas = idiomas;
	}






	public Horario getHorario() {
		return horario;
	}






	public void setHorario(Horario horario) {
		this.horario = horario;
	}






	public SxP getSxp() {
		return sxp;
	}






	public void setSxp(SxP sxp) {
		this.sxp = sxp;
	}






	public List<Reserva> getReserva() {
		return reserva;
	}






	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}






	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

}
