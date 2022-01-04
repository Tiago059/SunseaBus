package com.sunsea.SunseaBus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sunsea.SunseaBus.model.Localidade;

@RepositoryRestResource  
public interface LocalidadeRepository extends JpaRepository<Localidade, Integer>{
	
	List<Localidade> findByDescricaoContains(String nome);
	
	// findby tipo localidade

}
