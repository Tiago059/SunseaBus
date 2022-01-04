package com.sunsea.SunseaBus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sunsea.SunseaBus.model.TipoLocalidade;
import com.sunsea.SunseaBus.repository.TipoLocalidadeRepository;

@RestController
@RequestMapping("/sunsea/tiposLocalidade")
public class TipoLocalidadeController {
	
	@Autowired
	TipoLocalidadeRepository tipoLocalidadeRepository;
	
	/**
	 * Método padrão do endpoint que serve para trazer todos os 
	 * tipos de localidade cadastrados sem filtro de pesquisa.
	 * 
	 * @return todos os tipos de localidade
	 */
	@GetMapping
	public List<TipoLocalidade> todosTiposLocalidade() {
		return tipoLocalidadeRepository.findAll();
	}
	
	/**
	 * Método que através de parâmetro passado na URL, procura todos
	 * os tipos de localidades que contenham o nome informado.
	 * 
	 * @param nome a ser pesquisado
	 * @return lista de tipos de localidade contendo o nome informado
	 */
	@GetMapping("/{nome}")
	public List<TipoLocalidade> tiposLocalidadePorNome(@PathVariable String nome){
		return tipoLocalidadeRepository.findByNomeContains(nome);
	}
	
	/**
	 * Método que cadastra via um objeto JSON um tipo de localidade.
	 * Não é necessário informar o nome do endpoint e nem o ID do 
	 * tipo de localidade.
	 * 
	 * @param tipoLocalidade (em JSON)
	 * @return
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public TipoLocalidade cadastrarTipoLocalidade(@RequestBody TipoLocalidade tipoLocalidade) {
		return tipoLocalidadeRepository.save(tipoLocalidade);
	}
	
	/**
	 * Método que atualiza um tipo de localidade dado um ID, caso exista
	 * uma entidade associada. Os dados são passados via JSON.
	 * 
	 * @param tipoLocalidade - o tipo de localidade com as alterações
	 * @param id - id do tipo de localidade a ser atualizado
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarTipoLocalidade(@RequestBody TipoLocalidade tipoLocalidade, 
												     @PathVariable long id) {

		Optional<TipoLocalidade> tipoLocalidadeOptional = tipoLocalidadeRepository.findById(id);

		if (!tipoLocalidadeOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		tipoLocalidade.setId(id);
		tipoLocalidadeRepository.save(tipoLocalidade);

		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Método que usa o nome padrão do endpoint e através de um
	 * id, deleta o tipo de localidade correspondente ao ID (quando existir).
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirTipoLocalidadePorId(@PathVariable long id) {
		
		Optional<TipoLocalidade> tipoLocalidadeOptional = tipoLocalidadeRepository.findById(id);
		
		if (!tipoLocalidadeOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		tipoLocalidadeRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
