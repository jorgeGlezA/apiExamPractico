package com.mx.apiExamenPractico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.apiExamenPractico.model.Jobs;

public interface JobsDao extends JpaRepository<Jobs, Long> {

}
