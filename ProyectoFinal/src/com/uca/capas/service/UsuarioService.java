package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Usuario;


public interface UsuarioService {
	
	public List<Usuario> findByNUsuario(String usuario);
	
	public List<Usuario> findAll();
	
	//Creo un método de búsqueda por Id xd
	public Usuario findByCUsuario(Integer id);
	
	//Creo los métodos delete y save
	public void delete(Usuario usuario);
	
	public Usuario save(Usuario usuario);

}
