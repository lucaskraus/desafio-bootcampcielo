package br.com.ada.cielo.primeirodesafio.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.ada.cielo.primeirodesafio.components.FeedbackComponent;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackDTO;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.TipoFeedback;

@Component
public class RunnerInicializacao implements ApplicationRunner {

	@Autowired
	FeedbackComponent feedbackComponent;

	private final String MENSAGEM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum...";

	@Override
	public void run(ApplicationArguments args) throws Exception {

		TipoFeedback[] tipos = TipoFeedback.values();
		
		int tipoInd = 0; 
		
		for (int i = 0; i < 10; i++) {
			feedbackComponent.publicarFeeedback(CustomerFeedbackDTO.builder()//
					.mensagem(MENSAGEM)//
					.tipoFeedback(tipos[tipoInd].getCodigo())//
					.build());
			
			tipoInd = tipoInd < 2 ? tipoInd + 1 : 0; 
			
			Thread.sleep(5000);
		}
	}

}
