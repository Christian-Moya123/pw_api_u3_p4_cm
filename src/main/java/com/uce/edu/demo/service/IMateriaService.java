package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Materia;
import com.uce.edu.demo.service.to.MateriaTO;

public interface IMateriaService {
	
	public Materia consultarPorCodigo(String codigo);
	public void guardarMateria(Materia materia);
	
	public  void actualizarMateria(Materia materia);
	public  void eliminarMateria(Integer id);
	public List<Materia> buscarTodosMateria();
	
	public List<MateriaTO> buscarPorCedulaEstudiante(String cedula);
	public MateriaTO buscarPorId(Integer id);


}
