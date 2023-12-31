package com.uce.edu.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.IEstudianteService;


@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {
	
	@Autowired
	private IEstudianteService estudianteService;

	//GET
	@GetMapping(path="/buscar")
	public Estudiante consultarPorCedula() {
		String cedula = "1234567890";
		return this.estudianteService.consultarPorCedula(cedula);
	}
	
	@PostMapping(path="/guardarr")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardarEstudiante(estudiante);
		
	}
	
	@PutMapping(path="/actualizar")
	public void actualizar(){
		
	}
	
	@PatchMapping(path="/actualizarParcial")
	public void actualizarparcial(){
		
	}
	
	@DeleteMapping(path="/borrar")
	public void borrar(){
		
	}

}
