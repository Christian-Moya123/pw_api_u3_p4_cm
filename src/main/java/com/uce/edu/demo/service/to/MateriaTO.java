package com.uce.edu.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class MateriaTO extends RepresentationModel<MateriaTO> implements Serializable {
	
	private Integer id;

	private String nombre;
	
	private String creditos;
	
	//get y set

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	
	
	

}
