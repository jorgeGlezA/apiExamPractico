package com.mx.apiExamenPractico.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.apiExamenPractico.dao.EmployeesDao;
import com.mx.apiExamenPractico.dao.GendersDao;
import com.mx.apiExamenPractico.dao.JobsDao;
import com.mx.apiExamenPractico.model.Employees;
import com.mx.apiExamenPractico.model.Genders;
import com.mx.apiExamenPractico.model.Jobs;

@Service
public class EmployeesImp {

	@Autowired
	EmployeesDao employeesDao;

	@Autowired
	GendersDao genderDao;

	@Autowired
	JobsDao jobsDao;

	public List<Employees> listar() {
		return employeesDao.findAll();
	}

	// --> VALIDAR NOMBRE Y APELLIDO NO EXISTAN
	// ser mayor de edad,
	// --> SEXO EXISTIR EN GENDES
	// --> PUESTO EN JOBS

	public String guardar(Employees empleado) {

		String mensaje = "";
		boolean banderaGender = false;
		boolean banderaJob = false;
		boolean banderaEmp = false;
		// LocalDate fechaHoy = LocalDate.now();

		for (Jobs j : jobsDao.findAll()) {
			if (j.getName().equals(empleado.getJob().getName())) {
				banderaJob = true;

				for (Genders g : genderDao.findAll()) {
					if (g.getName().equals(empleado.getGender().getName())) {
						banderaGender = true;

						for (Employees e : listar()) {
							if (e.getId().equals(empleado.getId())) {
								mensaje = "ExisteId";
								banderaEmp = true;
								break;
							}
							String namePre = e.getName() + e.getLastName();
							String namePost = empleado.getName() + empleado.getLastName();
							if (namePre.equals(namePost)) {
								mensaje = "existeEmplado";
								banderaEmp = true;
								break;
							}
							// Editar

							String msj = validarFecha(empleado.getBirthday());
							if (msj.equals("menorEdad")) {
								mensaje = "menorEdad";
								banderaEmp = true;
								break;
							}
						}
						break;
					}
				}
				break;
			}
		}

		if (banderaJob == false) {
			mensaje = "jobNoExiste";
			banderaEmp = true;
		} else if (banderaGender == false) {
			mensaje = "genderNoExiste";
			banderaEmp = true;
		} else if (banderaEmp == false) {
			employeesDao.save(empleado);
		}

		return mensaje;
	}

	public Employees buscar(Long id) {
		return employeesDao.findById(id).orElse(null);
	}

	public String editar(Employees empleado) {

		String mensaje = "";
		boolean banderaId = false;

		for (Employees e : listar()) {
			if (e.getId().equals(empleado.getId())) {
				banderaId = true;
				employeesDao.save(empleado);
				break;
			}
		}

		if (banderaId == false) {
			mensaje = "idEmpleadoNoExisteId";
		}

		return mensaje;
	}

	// Validar que existe ID
	public boolean eliminar(Long id) {

		boolean banderaEli = false;

		for (Employees e : listar()) {
			if (e.getId().equals(id)) {
				banderaEli = true;
				break;
			}
		}

		if (banderaEli == true)
			employeesDao.deleteById(id);

		return banderaEli;
	}

	public String validarFecha(Date fecha) {
		int edad;
		String mensaje = "";
		LocalDate hoy = LocalDate.now();
		LocalDate fechaNa = new java.sql.Date(fecha.getTime()).toLocalDate();

		Period periodo = Period.between(fechaNa, hoy);

		edad = periodo.getYears();

		System.out.println(edad);

		if (edad < 18) {
			mensaje = "menorEdad";
		} else {
			mensaje = "mayorEdad";
		}

		return mensaje;
	}
}
