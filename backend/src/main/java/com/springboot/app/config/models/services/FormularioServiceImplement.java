package com.springboot.app.config.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.config.models.dao.IFormularioDao;
import com.springboot.app.config.models.entity.Formulario;
import com.springboot.app.config.models.entity.Genero;

@Service
public class FormularioServiceImplement implements IFormularioService {
	
	@Autowired
	private IFormularioDao formularioDao;

	@Override
	@Transactional(readOnly = true )
	public List<Formulario> findAll() {		
		return (List<Formulario>) formularioDao.findAll();
	}

	@Override
	public Formulario save(Formulario formulario) {		
		return formularioDao.save(formulario);
	}

	@Override
	@Transactional(readOnly = true )
	public List<Genero> findAllOpciones() {		
		return formularioDao.findAllOpciones();
	}

	@Override
	@Transactional(readOnly = true )
	public Page<Formulario> findAll(Pageable pageable) {
		return formularioDao.findAll(pageable);
	}
	
	

}
