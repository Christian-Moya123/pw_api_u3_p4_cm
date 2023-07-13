package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface  IEstudianteService {
	public Estudiante consultarPorCedula(String cedula);
	public  void guardarEstudiante(Estudiante estudiante);

}
