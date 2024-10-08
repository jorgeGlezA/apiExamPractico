package com.mx.apiExamenPractico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.apiExamenPractico.model.Jobs;
import com.mx.apiExamenPractico.service.JobsImp;

@RestController
@RequestMapping(path = "Jobs")
@CrossOrigin
public class JobsWs {

	@Autowired
	JobsImp imp;

	// http://localhost:9000/Jobs/listar
	@GetMapping("listar")
	public List<Jobs> listar() {
		return imp.listar();
	}

	// http://localhost:9000/Jobs/guardar
	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@RequestBody Jobs job) {
		String respuesta = imp.guardar(job);

		if (respuesta.equals("existeId")) {
			return new ResponseEntity<>("Ese registro ya existe, no se puede guardar", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(job, HttpStatus.CREATED);
		}
	}
	
	// http://localhost:9000/Jobs/buscar
	@PostMapping("buscar")
	public Jobs buscar(@RequestBody Jobs job) {
		return imp.buscar(job.getId());
	}

	// http://localhost:9000/Jobs/editar
	@PostMapping("editar")
	public ResponseEntity<?> editar(@RequestBody Jobs job) {
		boolean bandera = imp.editar(job);

		if (bandera == false) {
			return new ResponseEntity<>("Ese registro no existe, no se puede editar", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(job, HttpStatus.CREATED);
		}
	}
	
	
	// http://localhost:9000/Jobs/eliminar
	@PostMapping("eliminar")
	public ResponseEntity<String> eliminar (@RequestBody Jobs job){
		boolean bandera = imp.eliminar(job.getId());
		
		if (bandera == false) {
			return new ResponseEntity<>("No existe el id a eliminar", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Se elimino con exito", HttpStatus.OK);
		}
	}
}
