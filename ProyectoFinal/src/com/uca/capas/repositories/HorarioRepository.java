package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Integer>{

	public List<Horario> findAll();
}
