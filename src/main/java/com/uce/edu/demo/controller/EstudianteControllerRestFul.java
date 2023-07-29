package com.uce.edu.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.IEstudianteService;
import com.uce.edu.demo.service.IMateriaService;
import com.uce.edu.demo.service.to.EstudianteTO;
import com.uce.edu.demo.service.to.MateriaTO;

import org.springframework.hateoas.Link;

//Importacion estática
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IMateriaService iMateriaService;

	//GET
	@GetMapping(path="/{cedula}")
	public ResponseEntity<Estudiante> consultarPorCedula(@PathVariable String cedula) {
		//String cedula = "1234567890";
		
		return ResponseEntity.status(227).body(this.estudianteService.consultarPorCedula(cedula));
	}
	
	//GET
		@GetMapping(path="/status/{cedula}")
		
		public ResponseEntity<Estudiante> consultarPorCedulaStatus(@PathVariable String cedula) {
			//String cedula = "1234567890";
			
			return ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.consultarPorCedula(cedula));
		}
	
		//GET
		@GetMapping(path="/produces/{cedula}", produces = MediaType.APPLICATION_XML_VALUE)
		@ResponseStatus(code = HttpStatus.BAD_REQUEST)
		public Estudiante consultarPorCedulaProduces(@PathVariable String cedula) {
			//return ResponseEntity.status(227).body(this.estudianteService.consultarPorCedula(cedula));
			return this.estudianteService.consultarPorCedula(cedula);
		}
		
		
		
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardarEstudiante(estudiante);
		
	}
	
	@PostMapping(path="/guardar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public Estudiante guardar2(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardarEstudiante(estudiante);
		return this.consultarPorCedulaProduces(estudiante.getCedula());
	}

	
	@PutMapping(path="/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador){
		//Integer identificador=1;
		estudiante.setId(identificador);
		this.estudianteService.actualizarEstudiante(estudiante);
		
	}
	
	@PatchMapping(path="/{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante,
			@PathVariable Integer identificador) {
		String cedula = "1234567890";
		
		estudiante.setId(identificador);
		
		Estudiante estu1 = this.estudianteService.consultarPorCedula(cedula);
		estu1.setCedula(estudiante.getCedula());
		this.estudianteService.actualizarEstudiante(estu1);
	}
	
	@DeleteMapping(path="/{id}")
	public void borrar(@PathVariable Integer id){
		
		this.estudianteService.eliminar(id);
		
	}
	
	@GetMapping(path="/hateoas" , produces = MediaType.APPLICATION_JSON_VALUE)//path didactico, no se debe usar verbos
	public ResponseEntity<List<EstudianteTO>> consultarTodosHATEOAS(){
		List<EstudianteTO> lista = this.estudianteService.buscarTodosHATEOAS();
		//link de hypermedia para cada objeto
		for(EstudianteTO e: lista) {
			Link myLink = linkTo(methodOn(EstudianteControllerRestFul.class)
					.consultarPorCedula(e.getCedula()))
					.withRel("materias");

			e.add(myLink);

		}
		return new ResponseEntity<>(lista, null, 200);
	}

	@GetMapping(path = "/{cedula}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> buscarPorEstudiante(@PathVariable String cedula) {
		List<MateriaTO> lista = this.iMateriaService.buscarPorCedulaEstudiante(cedula);
		for (MateriaTO mat : lista) {
			Link myLink = linkTo(methodOn(MateriaControllerRestFul.class).consultarPorId(mat.getId()))
					.withRel("materia");
			mat.add(myLink);
		}

		return new ResponseEntity<>(lista, null, 200);
	}

}
