package com.mx.apiExamenPractico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.apiExamenPractico.model.EmployeeWorkedHours;
import com.mx.apiExamenPractico.service.EmployeeWorkedHoursImp;

@RestController
@RequestMapping("EmployeesWorkedHWs")
@CrossOrigin
public class EmployeesWorkedWs {

	@Autowired
	EmployeeWorkedHoursImp imp;
	
	// http://localhost:9000/EmployeesWorkedHWs/listar
	@GetMapping("listar")
	public List<EmployeeWorkedHours> listar(){
		return imp.listar();
	}
}
