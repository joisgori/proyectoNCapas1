package com.uca.capas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepository;

@Service
public class LoginServiceImp implements LoginService{
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Usuario findUsuario(String user, String pass) {

		return usuarioRepository.findByUserAndPass(user, pass);
	}
	
}
