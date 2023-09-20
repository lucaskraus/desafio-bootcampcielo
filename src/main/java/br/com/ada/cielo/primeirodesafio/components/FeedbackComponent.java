package br.com.ada.cielo.primeirodesafio.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackDto;
import br.com.ada.cielo.primeirodesafio.services.SnsService;

@Component
public class FeedbackComponent {

	private SnsService snsService;

	@Autowired
	public FeedbackComponent(SnsService snsService) {
		this.snsService = snsService;
	}

	public CustomerFeedbackDto publicarFeeedback(CustomerFeedbackDto feedback) {

		// TODO Auto-generated method stub

		snsService.publishMessageToSnsTopic("arn:aws:sns:us-east-1:081057868847:teste-sns.fifo",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "grupo 1");

		return null;
	}

}
