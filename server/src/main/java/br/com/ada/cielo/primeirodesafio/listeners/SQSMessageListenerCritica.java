package br.com.ada.cielo.primeirodesafio.listeners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ada.cielo.primeirodesafio.components.FeedbackComponent;
import br.com.ada.cielo.primeirodesafio.entities.CustomerFeedback;

@Component
public class SQSMessageListenerCritica implements ApplicationListener<ContextRefreshedEvent> {

	private final String PATH_BASE = "https://sqs.%s.amazonaws.com/%s/%s";

	@Autowired
	private AmazonSQS sqs;

	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	private FeedbackComponent component;
	
    @Value("${aws.region}")
    private String region;
    
    @Value("${aws.id.conta}")
    private String idConta;
    
	@Value("${aws.queue.critica}")
	private String queueCritica;

	@Async
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			String pathCompleto = String.format(PATH_BASE, region, idConta, queueCritica);
			ReceiveMessageRequest receiveRequest = new ReceiveMessageRequest(pathCompleto);
			
			while (true) {
				List<Message> messages = sqs.receiveMessage(receiveRequest).getMessages();
				for (Message message : messages) {
					CustomerFeedback feedback = mapper.readValue(message.getBody(), CustomerFeedback.class);
					component.processarFeedback(feedback);
					sqs.deleteMessage(pathCompleto, message.getReceiptHandle());
				}
				
				Thread.sleep(10000);
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
}
