package com.uce.edu.demo.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteRepository;
import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public Estudiante consultarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public void guardarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertarEstudiante(estudiante);
		
	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizarEstudiante(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.borrar(id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		// TODO Auto-generated method stub
		return	this.estudianteRepository.seleccionarTodos();
	}

	@Override
	public List<EstudianteTO> buscarTodosHATEOAS() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianteRepository.seleccionarTodos();
		List<EstudianteTO> listaTO = lista.stream().map(estudiante -> this.convertir(estudiante)).collect(Collectors.toList());

		return listaTO;
	}

	private EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO esTO = new EstudianteTO();
		esTO.setId(estudiante.getId());
		esTO.setNombre(estudiante.getNombre());
		esTO.setApellido(estudiante.getApellido());
		esTO.setCedula(estudiante.getCedula());
		esTO.setFechaNacimiento(estudiante.getFechaNacimiento());
		esTO.setProvincia(estudiante.getProvincia());
		return esTO;
	}
	


}
