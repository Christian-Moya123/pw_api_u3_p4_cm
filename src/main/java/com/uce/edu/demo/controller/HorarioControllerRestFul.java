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
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.repository.modelo.Horario;
import com.uce.edu.demo.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioControllerRestFul {
	
	@Autowired
	private IHorarioService horarioService;
	
	//GET
	@GetMapping(path="/{codigo}")
	public Horario consultarPorDia(@PathVariable String codigo) {
		return this.horarioService.consultarHorarioPorCodigo(codigo);
	}

	//POST
	@PostMapping
	public void guardar(@RequestBody Horario horario) {
		this.horarioService.guardarHorario(horario);
	}

	//PUT
	@PutMapping(path="/{id}")
	public void actualizar(@RequestBody Horario horario, @PathVariable Integer id) {
		horario.setId(id);
		this.horarioService.actualizarHorario(horario);
	}

	//PATCH
	@PatchMapping(path="/{identificador}")
	public void actualizarParcial(@RequestBody Horario horario, 
			@PathVariable Integer identificador) {
		
		String codigo = "1999";
	    horario.setId(identificador);
	    Horario hora1 = this.horarioService.consultarHorarioPorCodigo(codigo);
	    hora1.setCodigo(horario.getCodigo());
	    this.horarioService.actualizarHorario(hora1);
	}

	//DELETE
	@DeleteMapping(path="/{id}")
	public void eliminar(@PathVariable Integer id) {
		this.horarioService.eliminarHorario(id);
	}

}
