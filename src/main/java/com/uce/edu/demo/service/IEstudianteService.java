package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.to.EstudianteTO;

public interface  IEstudianteService {
	public Estudiante consultarPorCedula(String cedula);
	public  void guardarEstudiante(Estudiante estudiante);
	
	public  void actualizarEstudiante(Estudiante estudiante);
	public  void eliminar(Integer id);
	public List<Estudiante> buscarTodos();
	
	public List<EstudianteTO> buscarTodosHATEOAS();

}
