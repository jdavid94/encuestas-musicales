package com.springboot.app.config.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.config.models.entity.Formulario;
import com.springboot.app.config.models.entity.Genero;
import com.springboot.app.config.models.services.IFormularioService;



@CrossOrigin(origins = { "http://localhost:4200/", "*" })
@RestController
@RequestMapping("/api")
public class FormularioController {
	
	@Autowired
	private IFormularioService formularioService;
	
	@GetMapping("/formularios")
	public List<Formulario> index() {
		return formularioService.findAll();		
	}

	
	@GetMapping("/formularios/page")
	public ResponseEntity<?> list(Pageable pageable) {
		return ResponseEntity.ok().body(formularioService.findAll(pageable));		
	}
	
	
	@PostMapping("/formulario")
	public ResponseEntity<?> create(@Valid @RequestBody Formulario formulario, BindingResult result) {	
		Formulario newFormulario = null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> {
						return "Campo '" + err.getField() +"' "+ err.getDefaultMessage();
					})
					.collect(Collectors.toList());
			response.put("Errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}		
		try {
			newFormulario = formularioService.save(formulario);			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error con metodo INSERT");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		response.put("mensaje", "Formulario Guardado con Exito!!");
		response.put("Formulario", newFormulario);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);		
	}
	
	@GetMapping("/formularios/opciones")
	public List<Genero> opcionesList() {
		return formularioService.findAllOpciones();		
	}
}
