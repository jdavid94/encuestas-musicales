package com.springboot.app.config;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.app.config.models.dao.IFormularioDao;
import com.springboot.app.config.models.entity.Formulario;
import com.springboot.app.config.models.entity.Genero;
import com.springboot.app.config.models.services.IFormularioService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class EncuestasBackendServiceApplicationTests {

	@Autowired
	IFormularioService formularioService;
	
	@Mock
	IFormularioDao formularioDao;
	
		
	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void createFormulario()	{
		Genero opcion1 = new Genero(Long.valueOf(1), "RAP");
	    Formulario mockFormulario1  = new Formulario(Long.valueOf(1), "test@gmail.com", opcion1, null);

	    formularioService.save(mockFormulario1);
		verify(formularioDao, times(1)).save(mockFormulario1);
	}
	
	
	@Test
	public void findAll()	{
		List<Formulario> list = new ArrayList<Formulario>();
		Genero opcion1 = new Genero(Long.valueOf(7), "RAP");
	    Formulario mockFormulario1  = new Formulario(Long.valueOf(1), "test@gmail.com", opcion1, null);
	    Genero opcion2 = new Genero(Long.valueOf(8), "ELECTRONICA");
	    Formulario mockFormulario2  = new Formulario(Long.valueOf(2), "test2@gmail.com", opcion2, null);
	    Genero opcion3 = new Genero(Long.valueOf(9), "CUMBIA");
	    Formulario mockFormulario3  = new Formulario(Long.valueOf(3), "test3@gmail.com", opcion3, null);    
	   		
	    list.add(mockFormulario1);
		list.add(mockFormulario2);
		list.add(mockFormulario3);		
		
		when(formularioDao.findAll()).thenReturn(list);

		// Test
		List<Formulario> ListFormularios = formularioService.findAll();

		assertEquals(3, ListFormularios.size());
		//verify(formularioDao, times(1)).findAll();
	}
	
	@Test
	public void findAllOpciones()	{	   				
		// Test - Tenemos 5 Registros Insertados en la BD
		List<Genero> ListOpciones = formularioService.findAllOpciones();
		assertEquals(5, ListOpciones.size());
		
	}
}
