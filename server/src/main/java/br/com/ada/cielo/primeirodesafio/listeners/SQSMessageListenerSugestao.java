package br.com.ada.cielo.primeirodesafio.listeners;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

@Component
public class SQSMessageListenerSugestao extends AbstractSQSMessageListener {

	@Value("${aws.queue.sugestao}")
	private String queueSugestao;

	@Async
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			String pathCompleto = String.format(PATH_BASE, region, idConta, queueSugestao);
			ReceiveMessageRequest receiveRequest = new ReceiveMessageRequest(pathCompleto);

			while (true) {
				List<Message> messages = sqs.receiveMessage(receiveRequest).getMessages();
				for (Message message : messages) {
					processarFeedback(message, pathCompleto);
				}
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
}
