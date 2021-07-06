package br.com.zupacademy.guilherme.proposta.cartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
	
	 @Query("Select c From Cartao c where id =:id")
	 Optional<Cartao> findByStringId(String id);
}