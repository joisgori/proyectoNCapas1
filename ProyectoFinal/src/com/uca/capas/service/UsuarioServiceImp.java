package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepository;

public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> findByNUsuario(String usario) {
		return usuarioRepository.findByNUsuario(usario);
	}

}
