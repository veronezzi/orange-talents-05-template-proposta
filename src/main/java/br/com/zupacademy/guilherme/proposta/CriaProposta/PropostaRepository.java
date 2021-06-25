package br.com.zupacademy.guilherme.proposta.CriaProposta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
	@Query("SELECT p FROM Proposta p WHERE p.status = 'ELEGIVEL' and p.cartao is NULL")
	List<Proposta> findAprovados();
}