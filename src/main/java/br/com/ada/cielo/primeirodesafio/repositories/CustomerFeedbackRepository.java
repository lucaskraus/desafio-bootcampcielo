package br.com.ada.cielo.primeirodesafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ada.cielo.primeirodesafio.entities.CustomerFeedback;

public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Long> {

}
