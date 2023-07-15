package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping(path="/buscar/{codigo}")
	public Materia consultarPorCodigo(@PathVariable String codigo) {
		
		
		return this.materiaService.consultarPorCodigo(codigo);
	}
	
	@PostMapping(path="/guardar")
	public void guardar(@RequestBody Materia materia) {
		this.materiaService.guardarMateria(materia);
		
	}
	
	@PutMapping(path="/actualizar/{identificador}")
	public void actualizar(@RequestBody Materia materia, @PathVariable Integer identificador){
		//Integer identificador=1;
		materia.setId(identificador);
		this.materiaService.actualizarMateria(materia);
		
	}
	
	@PatchMapping(path="/actualizarParcial/{identificador}/{codigo}")
	public void actualizarParcial(@RequestBody Materia materia,
			@PathVariable Integer identificador,
			@PathVariable String codigo) {
		materia.setId(identificador);
		Materia mate1 = this.materiaService.consultarPorCodigo(codigo);
		mate1.setCodigo(materia.getCodigo());
		this.materiaService.actualizarMateria(mate1);
	}
	
	@DeleteMapping(path="/borrar/{id}")
	public void borrar(@PathVariable Integer id){
		
		this.materiaService.eliminarMateria(id);
		
	}
	
	@GetMapping(path="/buscarTodos")
	public List<Materia> buscarTodos(@RequestParam String provincia){
		//buscarTodos?provincia=pichincha
		return this.materiaService.buscarTodosMateria();
	}


}
