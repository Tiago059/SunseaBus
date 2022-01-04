package com.sunsea.SunseaBus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * Entidade que representa uma Localidade, para identificar
 * um local no mundo real, que pode ir de uma rua até um 
 * terminal ou escola, por exemplo.
 * 
 * @author italo-tiago
 */

@Data
@Entity 
@Table(name = "localidade") 
@NoArgsConstructor @AllArgsConstructor
public class Localidade {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Getter
	private Integer id;
	
	@NonNull 
	@Getter @Setter 
	private String descricao;
	
	@NonNull 
	@Getter @Setter
	@OneToOne @JoinColumn(name = "tipo_localidade_id")
	private TipoLocalidade tipoLocalidade;

}
