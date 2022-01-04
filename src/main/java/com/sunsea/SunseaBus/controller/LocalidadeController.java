package com.sunsea.SunseaBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunsea.SunseaBus.model.Localidade;
import com.sunsea.SunseaBus.repository.LocalidadeRepository;

@RestController
@RequestMapping("/sunsea/localidade")
public class LocalidadeController {
	
	@Autowired
	LocalidadeRepository localidadeRepository;
	
	/**
	 * Método padrão do endpoint que serve para trazer todos as
	 * localidades cadastradas sem filtro de pesquisa.
	 * 
	 * @return todos as localidades
	 */
	@GetMapping
	public List<Localidade> todasLocalidade() {
		return localidadeRepository.findAll();
	}
	
	

}
