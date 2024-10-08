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

import com.mx.apiExamenPractico.model.Employees;
import com.mx.apiExamenPractico.service.EmployeesImp;

@RestController
@RequestMapping("EmployeesWs")
@CrossOrigin
public class EmployeesWs {

	@Autowired
	EmployeesImp imp;

	// http://localhost:9000/EmployeesWs/listar
	@GetMapping("listar")
	public List<Employees> listar() {
		return imp.listar();
	}

	// http://localhost:9000/EmployeesWs/guardar
	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@RequestBody Employees empleado) {
		String mensaje = imp.guardar(empleado);

		if (mensaje.equals("ExisteId")) {
			return new ResponseEntity<>("Ese Id de empleado ya existe, no se puede guardar", HttpStatus.OK);

		} else if (mensaje.equals("existeEmplado")) {
			return new ResponseEntity<>("El empleado ya se encuanetra registrado, no se puede guardar", HttpStatus.OK);

		} else if (mensaje.equals("menorEdad")) {
			return new ResponseEntity<>("El empleado es menor de edad, no se puede guardar", HttpStatus.OK);

		} else if (mensaje.equals("jobNoExiste")) {
			return new ResponseEntity<>("No existe el trabajo", HttpStatus.OK);

		} else if (mensaje.equals("genderNoExiste")) {
			return new ResponseEntity<>("No existe el gender", HttpStatus.OK);

		} else {
			return new ResponseEntity<>(empleado, HttpStatus.CREATED);
		}
	}

	// http://localhost:9000/EmployeesWs/buscar
	@PostMapping("buscar")
	public Employees buscar(@RequestBody Employees empleado) {
		return imp.buscar(empleado.getId());
	}

	// http://localhost:9000/EmployeesWs/editar
	@PostMapping("editar")
	public ResponseEntity<?> editar(@RequestBody Employees empleado) {
		String mensaje = imp.editar(empleado);

		if (mensaje.equals("idEmpleadoNoExisteId")) {
			return new ResponseEntity<>("Error, no existe ID empleado", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(empleado, HttpStatus.CREATED);
		}
	}

	// http://localhost:9000/EmployeesWs/eliminar
	@PostMapping("eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Employees empleado) {
		boolean bandera = imp.eliminar(empleado.getId());

		if (bandera == false) {
			return new ResponseEntity<>("No existe, no se puede eliminar", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Se elimino con exito", HttpStatus.OK);
		}
	}
}
