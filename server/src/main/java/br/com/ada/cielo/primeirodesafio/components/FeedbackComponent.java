package br.com.ada.cielo.primeirodesafio.components;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackResumoVO;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackVO;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.StatusMensagem;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.TipoFeedback;
import br.com.ada.cielo.primeirodesafio.repositories.CustomerFeedbackRepository;
import br.com.ada.cielo.primeirodesafio.services.SnsService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
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

	@Transactional(rollbackFor = Exception.class)
	public CustomerFeedbackVO publicarFeeedback(CustomerFeedbackDTO feedback) throws Exception {
		try {
			log.info("INICIO: publicarFeeedback(), Publicando feedback: {}", feedback);
			CustomerFeedback entity = salvarMensagem(feedback);
			this.enviarMensagemParaTopico(entity);
			
			log.info("FIM: publicarFeeedback()");

			return CustomerFeedbackBuilder.buildVO(entity);
		} catch (Exception e) {
			log.error("#### Erro ao publicar mensagem : {}, erro: {}", feedback, e);
			throw new Exception("Erro ao enviar mensagem");
		}
	}

	public List<CustomerFeedbackVO> buscarFeedbacks(String tipo) {
		TipoFeedback tipoFeedback = TipoFeedback.getEnum(tipo);
		return CustomerFeedbackBuilder.buildVO(repository.findByTipoFeedback(tipoFeedback));
	}

	private void enviarMensagemParaTopico(CustomerFeedback feedback) throws JsonProcessingException {
		String mensagem = mapper.writeValueAsString(feedback);
		String id = feedback.getId().toString();
		String groupID = "1234topico";
		String topico = topicos.get(feedback.getTipoFeedback());
		
		snsService.publishMessageToSnsTopic(mensagem, id, groupID, topico);
	}

	private CustomerFeedback salvarMensagem(CustomerFeedbackDTO feedbackDTO) {
		CustomerFeedback feedback = CustomerFeedbackBuilder.buildEntity(feedbackDTO, StatusMensagem.RECEBIDO);
		repository.save(feedback);
		return feedback;
	}

	public void processarFeedback(CustomerFeedback feedback) throws InterruptedException {
		alterarStatus(feedback, StatusMensagem.EM_PROCESSAMENTO);
		Thread.sleep(15000);
		alterarStatus(feedback, StatusMensagem.FINALIZADO);
	}

	private void alterarStatus(CustomerFeedback feedback, StatusMensagem status) {
		feedback.setStatus(status);
		repository.save(feedback);
	}

	public Map<String, String> getTipoFeedback() {
		return Arrays.asList(TipoFeedback.values()).stream()//
		.collect(Collectors.toMap(t -> t.getCodigo(), t -> t.getDescricao()));
	}

	public List<CustomerFeedbackResumoVO> resumoFeedback() {
		return repository.getResumoFeedback();
	}

}
