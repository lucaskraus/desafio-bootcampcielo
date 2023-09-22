package br.com.ada.cielo.primeirodesafio.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.ada.cielo.primeirodesafio.entities.CustomerFeedback;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackDto;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackDtoBuilder;
import br.com.ada.cielo.primeirodesafio.repositories.CustomerFeedbackRepository;
import br.com.ada.cielo.primeirodesafio.services.SnsService;

@Component
public class FeedbackComponent {

	@Autowired
	private SnsService snsService;

	@Autowired
	private CustomerFeedbackRepository repository;

	@Transactional
	public CustomerFeedbackDto publicarFeeedback(CustomerFeedbackDto feedback) throws Exception {
		try {

			CustomerFeedback entity = CustomerFeedbackDtoBuilder.buildBack(feedback);
			repository.save(entity);

			snsService.publishMessageToSnsTopic(entity);
			
			return CustomerFeedbackDtoBuilder.build(entity);
			
		} catch (Exception e) {
			throw new Exception("Erro ao enviar mensagem");
		}
	}

}
