package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Materia;

public interface IMateriaService {
	
	public Materia consultarPorCodigo(String codigo);
	public void guardarMateria(Materia materia);

}
