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

import com.mx.apiExamenPractico.model.Genders;
import com.mx.apiExamenPractico.service.GendersImp;

@RestController
@RequestMapping(path = "Gender")
@CrossOrigin
public class GendersWS {

	@Autowired
	GendersImp imp;

	// http://localhost:9000/Gender/listar
	@GetMapping("listar")
	public List<Genders> listar() {
		return imp.listar();
	}

	// http://localhost:9000/Gender/guardar
	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@RequestBody Genders gender) {
		String respuesta = imp.guardar(gender);

		if (respuesta.equals("existeId")) {
			return new ResponseEntity<>("Ese registro ya existe, no se puede guardar", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(gender, HttpStatus.CREATED);
		}
	}

	// http://localhost:9000/Gender/buscar
	@PostMapping("buscar")
	public Genders buscar(@RequestBody Genders gender) {
		return imp.buscar(gender.getId());
	}

	// http://localhost:9000/Gender/editar
	@PostMapping("editar")
	public ResponseEntity<?> editar(@RequestBody Genders gender) {
		boolean bandera = imp.editar(gender);

		if (bandera == false) {
			return new ResponseEntity<>("Ese registro no existe, no se puede editar", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(gender, HttpStatus.CREATED);
		}
	}

	// http://localhost:9000/Gender/eliminar
	@PostMapping("eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Genders gender) {
		boolean bandera = imp.eliminar(gender.getId());
		
		if (bandera == false) {
			return new ResponseEntity<>("No existe, no se puede elimimar", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Se elimino con exito", HttpStatus.OK);
		}
	}
}
