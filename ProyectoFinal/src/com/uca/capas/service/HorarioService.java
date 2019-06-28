package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Horario;

public interface HorarioService {

	public Horario save(Horario horario);
	
	public void delete(Horario horario);
	
	public Horario findOne(Integer horario);

	public List<Horario> findAll();

}

