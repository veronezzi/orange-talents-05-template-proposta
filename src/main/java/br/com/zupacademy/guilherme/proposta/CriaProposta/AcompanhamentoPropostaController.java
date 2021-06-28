package br.com.zupacademy.guilherme.proposta.CriaProposta;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposta")
public class AcompanhamentoPropostaController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	PropostaRepository propostaRepository;

	 @GetMapping("/{id}")
	    public ResponseEntity<?> consultarProposta(@PathVariable("id") Long id) {
	        Optional<Proposta> proposta = propostaRepository.findById(id);
	        if (proposta.isPresent()) {
	            return ResponseEntity.ok().body(new PropostaDto(proposta.get()));
	        }
	        return ResponseEntity.notFound().build();
	    }
}
