package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Horario;
import com.uca.capas.domain.Idiomas;

public interface IdiomaService {

	public Idiomas save(Idiomas idioma);
	
	public void delete(Idiomas idioma);
	
	public Idiomas findOne(Integer idioma);

	public List<Idiomas> findAll();

}
