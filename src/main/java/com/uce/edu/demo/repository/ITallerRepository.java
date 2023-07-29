package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Taller;

public interface ITallerRepository {
	
	public void guardar(Taller taller);
	public void actualizar(Taller taller);
	public void actualizarParcial(String tallerActual, String tallerNevo);
	public Taller buscar(String codigo);
	public List<Taller> buscarTodos();
	public Taller buscarId(Integer id);
	public void eliminar(Integer id);

}
