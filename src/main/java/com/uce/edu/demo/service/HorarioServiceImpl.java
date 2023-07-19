package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IHorarioRepository;
import com.uce.edu.demo.repository.modelo.Horario;

@Service
public class HorarioServiceImpl implements IHorarioService {

	@Autowired
	private IHorarioRepository horarioRepository;

	@Override
	public Horario consultarHorarioPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.horarioRepository.buscarHorarioPorCodigo(codigo);
	}

	@Override
	public List<Horario> consultarHorarios() {
		// TODO Auto-generated method stub
		return this.horarioRepository.buscarTodos();
	}

	@Override
	public void guardarHorario(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepository.insertarHorario(horario);
	}

	@Override
	public void actualizarHorario(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepository.actualizarHorario(horario);
	}

	@Override
	public void eliminarHorario(Integer id) {
		// TODO Auto-generated method stub
		this.horarioRepository.borrarHorario(id);
	}

	@Override
	public Horario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.horarioRepository.consultarPorId(id);
	}
}
