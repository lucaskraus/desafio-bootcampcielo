package br.com.ada.cielo.primeirodesafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ada.cielo.primeirodesafio.entities.CustomerFeedback;

public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Long> {
	
	@Query("SELECT cf FROM CustomerFeedback cf WHERE :tipoFeedback IS NULL OR cf.tipoFeedback = :tipoFeedback")
	List<CustomerFeedback> findByTipoFeedback(@Param("tipoFeedback") String tipoFeedback);
	
}
