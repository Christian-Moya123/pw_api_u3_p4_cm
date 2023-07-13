package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public Materia seleccionarPorCodigo(String codigo);
	public void insertarMateria(Materia materia);

}
