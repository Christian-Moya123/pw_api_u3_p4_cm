package com.uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Materia;
import com.uce.edu.demo.service.IEstudianteService;
import com.uce.edu.demo.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {
	
	@Autowired
	private IMateriaService materiaService;

	//GET
	@GetMapping(path="/buscar")
	public Materia consultarPorCodigo() {
		
		String codigo = "aa11";
		return this.materiaService.consultarPorCodigo(codigo);
	}
	
	@PostMapping(path="/guardar")
	public void guardar(@RequestBody Materia materia) {
		this.materiaService.guardarMateria(materia);
		
	}

}
