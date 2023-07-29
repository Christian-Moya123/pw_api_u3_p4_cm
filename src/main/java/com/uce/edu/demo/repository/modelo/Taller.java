package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="taller")
public class Taller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_taller")
	@SequenceGenerator(name="seq_taller", sequenceName = "seq_taller", allocationSize = 1)
	@Column(name = "tall_id")
	private Integer id;

	@Column(name = "tall_nombre")
	private String nombre;

	@Column(name = "tall_descripcion")
	private String descripcion;

	@Column(name = "tall_profesor")
	private String profesor;

	@Column(name = "tall_duracion")
	private LocalDateTime duracion;
	
	@Column(name = "tall_capacidad")
	private Integer capacidad;
	
	@Column(name = "tall_codigo")
	private String codigo;

	//set y get
	
	
	public Integer getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public LocalDateTime getDuracion() {
		return duracion;
	}

	public void setDuracion(LocalDateTime duracion) {
		this.duracion = duracion;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	
	


}
