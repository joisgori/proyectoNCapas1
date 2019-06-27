package com.uca.capas.service;

import com.uca.capas.domain.Usuario;

public interface LoginService {
	
	public Usuario findUsuario(String user, String pass);
	
}
