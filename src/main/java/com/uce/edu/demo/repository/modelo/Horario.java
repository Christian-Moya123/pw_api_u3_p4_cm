package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="horario")
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_horario")
	@SequenceGenerator(name="seq_horario", sequenceName = "seq_horario", allocationSize = 1)
	
	@Column(name = "hora_id")
	private Integer id;
	
	@Column(name = "hora_materia")
	private String materia;
	
	@Column(name = "hora_hora_ inicio")
	private LocalDateTime horaInicio;
	
	@Column(name = "hora_hora_fin")
	private LocalDateTime horaFIn;
	
	@Column(name = "hora_duracion")
	private Integer duracion;
	
	@Column(name = "hora_profesor")
	private String profesor;
	
	@Column(name = "hora_aula")
	private String  aula;
	
	@Column(name = "hora_codigo")
	private String  codigo;
	
	//get y set

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDateTime getHoraFIn() {
		return horaFIn;
	}

	public void setHoraFIn(LocalDateTime horaFIn) {
		this.horaFIn = horaFIn;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Override
	public String toString() {
		return "Horario [id=" + id + ", materia=" + materia + ", horaInicio=" + horaInicio + ", horaFIn=" + horaFIn
				+ ", duracion=" + duracion + ", profesor=" + profesor + ", aula=" + aula + "]";
	}
	
	
	
}
