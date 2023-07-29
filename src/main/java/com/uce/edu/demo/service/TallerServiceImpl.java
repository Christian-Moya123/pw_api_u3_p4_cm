package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ITallerRepository;
import com.uce.edu.demo.repository.modelo.Taller;

@Service
public class TallerServiceImpl implements ITallerService{
	
	@Autowired
	private ITallerRepository aulaRepository;

	@Override
	public void guardarTallerr(Taller taller) {
		// TODO Auto-generated method stub
		this.aulaRepository.guardar(taller);
		
	}

	@Override
	public void actualizarTaller(Taller taller) {
		// TODO Auto-generated method stub
		this.aulaRepository.actualizar(taller);
		
	}

	@Override
	public void actualizarParalelo(String tallerActual, String tallerNuevo) {
		// TODO Auto-generated method stub
		this.aulaRepository.actualizarParcial(tallerActual, tallerNuevo);
		
	}

	@Override
	public Taller buscarTaller(String codigo) {
		// TODO Auto-generated method stub
		return this.aulaRepository.buscar(codigo);
	}

	@Override
	public List<Taller> buscarTodos() {
		// TODO Auto-generated method stub
		return this.aulaRepository.buscarTodos();
	}

	@Override
	public void borrarTaller(Integer id) {
		// TODO Auto-generated method stub
		this.aulaRepository.eliminar(id);
	}

}
