package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public Materia seleccionarPorCodigo(String codigo);
	public void insertarMateria(Materia materia);
	
	public void actualizarMateria(Materia materia);
	public void actualizarParcialMateria(String codigoActual, String codigoNueva);
	public  void borrar(Integer id);
	public Materia borrarPorIdMateria(Integer id);
	public List<Materia> seleccionarTodosMateria();
	public List<Materia> buscarPorCedulaEstudiante(String cedula);
	public Materia buscarPorId(Integer id);

}
