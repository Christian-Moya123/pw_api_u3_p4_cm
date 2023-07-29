package com.uce.edu.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.uce.edu.demo.repository.modelo.Materia;
import com.uce.edu.demo.repository.modelo.Taller;
import com.uce.edu.demo.service.ITallerService;
import com.uce.edu.demo.service.to.EstudianteTO;

@RestController
@RequestMapping("/talleres")
public class TallerControllerRestful {
	
	@Autowired
	private ITallerService tallerService;
	
	@GetMapping(path = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Taller> buscar(@PathVariable String codigo) {
		return ResponseEntity.status(HttpStatus.OK).body(this.tallerService.buscarTaller(codigo));
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void guardar(@RequestBody Taller taller) {
		this.tallerService.guardarTallerr(taller);
	}
	
	@PutMapping(path="/{identificador}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void actualizar(@RequestBody Taller taller, @PathVariable Integer identificador) {
		taller.setId(identificador);
		this.tallerService.actualizarTaller(taller);
	}
	
	@PatchMapping(path = "/{codigo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void actualizarCodigo(@RequestBody Taller taller, @PathVariable String codigo) {
	    Taller tallerExistente = this.tallerService.buscarTaller(codigo);
	    this.tallerService.actualizarParalelo(tallerExistente.getCodigo(), taller.getCodigo());
	}
	
	@GetMapping
	public List<Taller> buscarTodos(){
	
		return this.tallerService.buscarTodos();
	}
	
	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void borrar(@PathVariable Integer id) {
		this.tallerService.borrarTaller(id);
	}
	
	
	

}
