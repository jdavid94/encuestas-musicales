package com.springboot.app.config.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.springboot.app.config.models.entity.Formulario;
import com.springboot.app.config.models.entity.Genero;


public interface IFormularioService {
	public List<Formulario> findAll();
	public Formulario save(Formulario formulario);
	public List<Genero> findAllOpciones();
	public Page<Formulario> findAll(Pageable pageable);
}
