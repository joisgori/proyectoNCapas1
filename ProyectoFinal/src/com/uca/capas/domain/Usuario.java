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

import com.uca.capas.domain.Reserva;

@Entity
@Table(schema = "public", name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(generator = "usuario_id_usuario_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "usuario_id_usuario_seq", sequenceName = "public.usuario_id_usuario_seq", allocationSize = 1)
	@Column(name = "id_usuario")
	private Integer cUsuario;

	@Column(name = "nombre_usuario")
	private String aUsuario;

	@Column(name = "apellido_usuario")
	private String aApellido;

	@Column(name = "fecha_de_nacimiento")
	private String fNacimiento;

	@Column(name = "direccion_de_residencia")
	private String resUsuario;

	@Column(name = "estado")
	private Boolean estadoUsuario;

	@Column(name = "user_login")
	private String user;

	@Column(name = "password_login")
	private String pass;

	@Column(name = "user_type")
	private String nUsuario;

	@Column(name = "saldo_cuenta")
	private Double saldoCuenta;
	
	@Column(name = "is_logged")
	private Boolean loggedIn;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Reserva> reserva;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_provincia")
	private Provincia provincia;

	public Usuario() {
		super();
	}

	
	public Usuario(Integer cUsuario, String aUsuario, String aApellido, String fNacimiento, String resUsuario,
			Boolean estadoUsuario, String user, String pass, String nUsuario, Double saldoCuenta, Boolean loggedIn,
			List<Reserva> reserva, Provincia provincia) {
		super();
		this.cUsuario = cUsuario;
		this.aUsuario = aUsuario;
		this.aApellido = aApellido;
		this.fNacimiento = fNacimiento;
		this.resUsuario = resUsuario;
		this.estadoUsuario = estadoUsuario;
		this.user = user;
		this.pass = pass;
		this.nUsuario = nUsuario;
		this.saldoCuenta = saldoCuenta;
		this.loggedIn = loggedIn;
		this.reserva = reserva;
		this.provincia = provincia;
	}

	public Integer getcUsuario() {
		return cUsuario;
	}

	public void setcUsuario(Integer cUsuario) {
		this.cUsuario = cUsuario;
	}

	public String getaUsuario() {
		return aUsuario;
	}

	public void setaUsuario(String aUsuario) {
		this.aUsuario = aUsuario;
	}

	public String getaApellido() {
		return aApellido;
	}

	public void setaApellido(String aApellido) {
		this.aApellido = aApellido;
	}

	public String getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getResUsuario() {
		return resUsuario;
	}

	public void setResUsuario(String resUsuario) {
		this.resUsuario = resUsuario;
	}

	public Boolean getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(Boolean estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getnUsuario() {
		return nUsuario;
	}

	public void setnUsuario(String nUsuario) {
		this.nUsuario = nUsuario;
	}

	public Double getSaldoCuenta() {
		return saldoCuenta;
	}

	public void setSaldoCuenta(Double saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}



	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
}
