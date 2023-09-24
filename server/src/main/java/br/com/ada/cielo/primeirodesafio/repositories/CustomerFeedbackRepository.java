package br.com.ada.cielo.primeirodesafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ada.cielo.primeirodesafio.entities.CustomerFeedback;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackResumoVO;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.TipoFeedback;

public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Long> {

	@Query("SELECT cf FROM CustomerFeedback cf WHERE :tipoFeedback IS NULL OR cf.tipoFeedback = :tipoFeedback")
	List<CustomerFeedback> findByTipoFeedback(@Param("tipoFeedback") TipoFeedback tipoFeedback);

	@Query("SELECT NEW br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackResumoVO(" //
			+ " c.tipoFeedback," //
			+ "SUM(CASE WHEN c.status = 'RECEBIDO' THEN 1 ELSE 0 END) AS RECEBIDO_COUNT, " //
			+ "SUM(CASE WHEN c.status = 'EM_PROCESSAMENTO' THEN 1 ELSE 0 END) AS EM_PROCESSAMENTO_COUNT, " //
			+ "SUM(CASE WHEN c.status = 'FINALIZADO' THEN 1 ELSE 0 END) AS FINALIZADO_COUNT, " //
			+ "COUNT(c)) " + "FROM CustomerFeedback c " //
			+ "GROUP BY c.tipoFeedback")
	List<CustomerFeedbackResumoVO> getResumoFeedback();

}
