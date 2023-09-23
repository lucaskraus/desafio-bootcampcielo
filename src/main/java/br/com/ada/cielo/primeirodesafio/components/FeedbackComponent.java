package br.com.ada.cielo.primeirodesafio.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ada.cielo.primeirodesafio.entities.CustomerFeedback;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackBuilder;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackDTO;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackVO;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.StatusMensagem;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.TipoFeedback;
import br.com.ada.cielo.primeirodesafio.repositories.CustomerFeedbackRepository;
import br.com.ada.cielo.primeirodesafio.services.SnsService;

@Component
public class FeedbackComponent {

	@Autowired
	private SnsService snsService;

	@Autowired
	private CustomerFeedbackRepository repository;

	@Autowired
	ObjectMapper mapper;

	@Value("${aws.topico.critica}")
	private String topicoCritica;

	@Value("${aws.topico.elogio}")
	private String topicoElogio;

	@Value("${aws.topico.sugestao}")
	private String topicoSugestao;

	private final Map<TipoFeedback, String> topicos = new HashMap<>();

	@PostConstruct
	public void initialize() {
		topicos.put(TipoFeedback.CRITICA, topicoCritica);
		topicos.put(TipoFeedback.ELOGIO, topicoElogio);
		topicos.put(TipoFeedback.SUGESTAO, topicoSugestao);
	}

	@Transactional
	public CustomerFeedbackVO publicarFeeedback(CustomerFeedbackDTO feedback) throws Exception {
		try {
			CustomerFeedback entity = salvarMensagem(feedback);
			this.enviarMensagemParaTopico(entity);

			return CustomerFeedbackBuilder.buildVO(entity);
		} catch (Exception e) {
			throw new Exception("Erro ao enviar mensagem");
		}
	}

	public List<CustomerFeedbackVO> buscarFeedbacks(String tipo) {
		return CustomerFeedbackBuilder.buildVO(repository.findByTipoFeedback(tipo));
	}

	private void enviarMensagemParaTopico(CustomerFeedback feedback) throws JsonProcessingException {
		String mensagem = mapper.writeValueAsString(feedback);
		String id = feedback.getId().toString();
		// TODO:verificar regra
		String groupID = "topico123";
		snsService.publishMessageToSnsTopic(mensagem, id, groupID, topicos.get(feedback.getTipoFeedback()));

	}

	private CustomerFeedback salvarMensagem(CustomerFeedbackDTO feedbackDTO) {
		CustomerFeedback feedback = CustomerFeedbackBuilder.buildEntity(feedbackDTO, StatusMensagem.RECEBIDO);
		repository.save(feedback);
		return feedback;
	}

	public void processarFeedback(CustomerFeedback feedback) throws InterruptedException {
		alterarStatus(feedback, StatusMensagem.EM_PROCESSAMENTO);
		Thread.sleep(30000);
		alterarStatus(feedback, StatusMensagem.FINALIZADO);
	}

	private void alterarStatus(CustomerFeedback feedback, StatusMensagem status) {
		feedback.setStatus(status);
		repository.save(feedback);
	}

}
