package br.com.zupacademy.guilherme.proposta.biometria;

import java.net.URI;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.zupacademy.guilherme.proposta.cartao.Cartao;
import br.com.zupacademy.guilherme.proposta.cartao.CartaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/biometrias")
public class BiometriaController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    EntityManager manager;

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<?> cadastrar(@PathVariable("id") String id, @RequestBody @Valid BiometriaForm biometriaForm,
            UriComponentsBuilder uriComponentsBuilder) { 
   
        try {
            Optional<Cartao> card = cartaoRepository.findByStringId(id);

            Biometria biometria = biometriaForm.toModel(card.get());
            manager.persist(biometria);

            URI path = uriComponentsBuilder.path("/api/biometrias/{id}").buildAndExpand(biometria.getId()).toUri();

            return ResponseEntity.created(path).build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}