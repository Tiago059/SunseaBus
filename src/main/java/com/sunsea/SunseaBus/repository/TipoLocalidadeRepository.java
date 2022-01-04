package com.sunsea.SunseaBus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sunsea.SunseaBus.model.TipoLocalidade;

@RepositoryRestResource
public interface TipoLocalidadeRepository extends JpaRepository<TipoLocalidade, Long> {
	
	/**
	 * Usando o padrão camel case do Jpa para procurar contains.
	 * @param nome
	 * @return
	 */
	List<TipoLocalidade> findByNomeContains(String nome);

}
