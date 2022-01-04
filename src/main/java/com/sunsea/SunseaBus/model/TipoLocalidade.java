package com.sunsea.SunseaBus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * Entidade que representa um Tipo de Localidade, servindo
 * para classificar Localidades.
 * 
 * @author italo-tiago
 *
 */
@Data
@Entity @Table(name = "tipo_localidade") 
@NoArgsConstructor @AllArgsConstructor
public class TipoLocalidade {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;
	
	@NonNull
	@Getter @Setter 
	private String nome;

}
