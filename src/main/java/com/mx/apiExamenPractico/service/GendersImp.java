package com.mx.apiExamenPractico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.apiExamenPractico.dao.GendersDao;
import com.mx.apiExamenPractico.model.Genders;

@Service
public class GendersImp {

	@Autowired
	GendersDao dao;

	public List<Genders> listar() {
		return dao.findAll();
	}

	// Validar que no se repita ID
	public String guardar(Genders gender) {

		String respuesta = "";

		for (Genders g : listar()) {
			if (g.getId().equals(gender.getId())) {
				respuesta = "existeId";
				break;
			}
		}

		if (respuesta.equals("")) {
			dao.save(gender);
		}
		return respuesta;
	}

	public Genders buscar(Long id) {
		return dao.findById(id).orElse(null);
	}

	// Validar que existe ID
	public boolean editar(Genders gender) {

		boolean bandera = false;

		for (Genders g : listar()) {
			if (g.getId().equals(gender.getId())) {
				bandera = true;
				break;
			}
		}

		if (bandera == true) {
			dao.save(gender);
		}

		return bandera;
	}

	// Validar que existe Id
	public boolean eliminar (Long id) {
		
		boolean banderaELi = false;
		for (Genders g: listar()) {
			if (g.getId().equals(id)) {
				banderaELi = true;
				break;
			}
		}
		
		
		if (banderaELi == true)
			dao.deleteById(id);
		
		return banderaELi;
	}
}
