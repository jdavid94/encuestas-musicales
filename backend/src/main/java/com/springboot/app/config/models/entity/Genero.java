package com.springboot.app.config.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="generos")
public class Genero implements Serializable {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
		
	@NotEmpty 
	private String genero;
			
	
	public Genero(Long id, @NotEmpty String genero) {
		super();
		this.id = id;
		this.genero = genero;
	}
	
	public Genero() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
