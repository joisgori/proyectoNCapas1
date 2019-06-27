package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> findByNUsuario(String usario) {
		return usuarioRepository.findByNUsuario(usario);
	}


	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}
