package com.mx.apiExamenPractico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.apiExamenPractico.dao.JobsDao;
import com.mx.apiExamenPractico.model.Jobs;

@Service
public class JobsImp {

	@Autowired
	JobsDao dao;

	public List<Jobs> listar() {
		return dao.findAll();
	}

	// Validar que no se repita id
	public String guardar(Jobs job) {

		String respuesta = "";	
		
		for (Jobs j : listar()) {
			
			if (j.getId().equals(job.getId())) {
				respuesta = "existeId";
				break;
			}
		}

		if (respuesta.equals(""))
			dao.save(job);

		return respuesta;
	}

	// Validar que existe ID
	public Jobs buscar(Long id) {
		return dao.findById(id).orElse(null);
	}

	public boolean editar (Jobs job) {
		
		boolean bandera = false;
		
		for (Jobs j : listar()) {
			if (j.getId().equals(job.getId())) {
				bandera = true;
				break;
			}
		}
		
		if (bandera == true)
			dao.save(job);
		
		return bandera;
	}
	
	// Validar que existe ID
	public boolean eliminar (Long id) {
		
		boolean banderaEliJob = false;
		
		for (Jobs j: listar()) {
			if (j.getId().equals(id)) {
				banderaEliJob = true;
				break;
			}
		}
		
		if (banderaEliJob = true)
			dao.deleteById(id);
		
		return banderaEliJob;
	}
	
}
