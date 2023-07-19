package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Horario;

public interface IHorarioService {
	
	public Horario consultarHorarioPorCodigo(String codigo);
	public List<Horario> consultarHorarios();
	public void guardarHorario(Horario horario);
	public void actualizarHorario(Horario horario);
	public void eliminarHorario(Integer id);
	public Horario buscarPorId(Integer id);
	


}
