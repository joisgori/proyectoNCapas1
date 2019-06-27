package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Usuario;


public interface UsuarioService {
	
	public List<Usuario> findByNUsuario(String usuario);
	
	public List<Usuario> findAll();

}
