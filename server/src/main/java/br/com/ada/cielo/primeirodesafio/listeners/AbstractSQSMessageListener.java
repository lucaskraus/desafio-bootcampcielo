package br.com.ada.cielo.primeirodesafio.listeners;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ada.cielo.primeirodesafio.components.FeedbackComponent;
import br.com.ada.cielo.primeirodesafio.entities.CustomerFeedback;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractSQSMessageListener implements ApplicationListener<ContextRefreshedEvent> {

	final String PATH_BASE = "https://sqs.%s.amazonaws.com/%s/%s";

	@Autowired
	AmazonSQS sqs;

	@Autowired
	ObjectMapper mapper;

	@Autowired
	FeedbackComponent feedbackComponent;

	@Value("${aws.region}")
	String region;

	@Value("${aws.id.conta}")
	String idConta;

	void processarFeedback(Message message, String url) throws Exception {
		sqs.changeMessageVisibility(url, message.getReceiptHandle(), 60);
		CustomerFeedback feedback = getFeedback(message.getBody());
		
		log.info("INICIO: processarFeedback(), Publicando feedback: {}", feedback);
		
		feedbackComponent.processarFeedback(feedback);
		sqs.deleteMessage(url, message.getReceiptHandle());
		
		log.info("FIM: processarFeedback()");
		
		Thread.sleep(10000);
	}

	private CustomerFeedback getFeedback(String mensagem) throws JsonProcessingException, JsonMappingException {
		TypeReference<Map<String, String>> mapType = new TypeReference<Map<String, String>>() {};
		Map<String, String> mensagemMap = mapper.readValue(mensagem, mapType);
		return mapper.readValue(mensagemMap.get("Message"), CustomerFeedback.class);
	}

}
