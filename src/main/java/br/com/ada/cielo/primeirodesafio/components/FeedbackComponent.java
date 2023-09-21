package br.com.ada.cielo.primeirodesafio.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	public CustomerFeedbackDto publicarFeeedback(CustomerFeedbackDto feedback) {

		CustomerFeedback entity = CustomerFeedbackDtoBuilder.buildBack(feedback);
		repository.save(entity);

		snsService.publishMessageToSnsTopic("arn:aws:sns:us-east-1:352245087617:teste-sns.fifo",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "10934932");

		return null;
	}

}
