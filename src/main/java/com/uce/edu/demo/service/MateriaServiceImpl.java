package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IMateriaRepository;
import com.uce.edu.demo.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {
	

	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public Materia consultarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionarPorCodigo(codigo);
	}

	@Override
	public void guardarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.insertarMateria(materia);
	}

}
