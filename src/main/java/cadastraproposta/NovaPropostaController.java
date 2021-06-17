package cadastraproposta;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/cadastrarProposta")
public class NovaPropostaController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String cadastrarUsuario(@RequestBody @Valid PropostaForm form) {
		Proposta proposta = form.toModel();
		manager.persist(proposta);
		return proposta.toString();

    }

}
