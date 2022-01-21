package com.springboot.app.config.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="formularios")
public class Formulario implements Serializable {	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@NotEmpty
	@Email
	@Column(nullable=false, unique=true)
	private String email;
	
	@NotNull(message="No puede estar vacio")
	@ManyToOne(fetch=FetchType.LAZY) // Indicamos relacion muchos a uno
	@JoinColumn(name="genero_id") // Clave que genera la relacion entre tablas.
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) 
	private Genero opcion;
		
	
	@Column(name="fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	

	public Formulario(Long id, @NotEmpty @Email String email, @NotNull(message = "No puede estar vacio") Genero opcion,
			Date fechaCreacion) {
		super();
		this.id = id;
		this.email = email;
		this.opcion = opcion;
		this.fechaCreacion = new Date();
	}
		

	public Formulario() {
		
	}


	@PrePersist
	public void prePersist() {
		this.fechaCreacion = new Date();			
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Genero getOpcion() {
		return opcion;
	}

	public void setOpcion(Genero opcion) {
		this.opcion = opcion;
	}

	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
