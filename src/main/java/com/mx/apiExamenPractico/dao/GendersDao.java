package com.mx.apiExamenPractico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.apiExamenPractico.model.Genders;

public interface GendersDao extends JpaRepository<Genders, Long> {

}
