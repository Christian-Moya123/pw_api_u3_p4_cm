package com.uce.edu.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="materia")
public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_materia")
	@SequenceGenerator(name="seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@Column(name = "mate_id")
	private Integer id;
	
	@Column(name = "mate_nombre")
	private String nombre;
	
	@Column(name = "mate_descripcion")
	private String descripcion;
	
	@Column(name = "mate_grado")
	private Integer grado;
	
	@Column(name = "mate_aula")
	private String aula;
	
	@Column(name = "mate_horario")
	private Integer horario;
	
	@Column(name = "mate_codigo")
	private String codigo;
	
	@Column(name = "mate_creditos")
	private String creditos;
	
	
	
	@ManyToOne
	@JoinColumn(name = "mate_id_estu")
	private Estudiante estudiante;
	
	
	
	//get y set


	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getGrado() {
		return grado;
	}

	public void setGrado(Integer grado) {
		this.grado = grado;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public Integer getHorario() {
		return horario;
	}

	public void setHorario(Integer horario) {
		this.horario = horario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}
	
	

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", grado=" + grado
				+ ", aula=" + aula + ", horario=" + horario + ", codigo=" + codigo + ", creditos=" + creditos + "]";
	}
	

}
