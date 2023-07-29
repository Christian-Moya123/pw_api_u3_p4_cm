package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Taller;

public interface ITallerService {
	
	public void guardarTallerr(Taller taller);

	public void actualizarTaller(Taller taller);

	public void actualizarParalelo(String tallerActual, String tallerNuevo);

	public Taller buscarTaller(String codigo);

	public List<Taller> buscarTodos();

	public void borrarTaller(Integer id);

}
