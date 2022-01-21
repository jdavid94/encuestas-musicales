package com.springboot.app.config.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.app.config.models.entity.Formulario;
import com.springboot.app.config.models.entity.Genero;

@Repository
public interface IFormularioDao extends JpaRepository<Formulario, Long> {
	
	@Query("from Genero")
	public List<Genero> findAllOpciones();

}
