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
	
	public int updateUser(Boolean bool, Integer id);
	
	public int inactivateUser(Boolean bool, String motivo, Integer id);

	public Usuario login(String user,  String pass);
	
	public Usuario findByUser(String nombre);

}
