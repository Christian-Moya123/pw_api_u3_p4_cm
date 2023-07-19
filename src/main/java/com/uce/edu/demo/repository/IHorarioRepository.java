package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Horario;

public interface IHorarioRepository {
	
	public Horario buscarHorarioPorCodigo(String codigo);
	public List<Horario> buscarTodos();
	public void insertarHorario(Horario horario);
	public void actualizarHorario(Horario horario);
	public void borrarHorario(Integer id);
	public Horario borrarHorarioPorId(Integer id);
	public Horario consultarPorId(Integer id);
	

}
