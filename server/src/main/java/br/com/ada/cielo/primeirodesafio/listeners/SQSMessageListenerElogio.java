package br.com.ada.cielo.primeirodesafio.listeners;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SQSMessageListenerElogio extends AbstractSQSMessageListener {

	@Value("${aws.queue.elogio}")
	private String queueElogio;

	@Value("${aws.queue.dead.elogio}")
	private String deadQueueElogio;

	@Async
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		String path = getPath(queueElogio);
		String deadPath = getPath(deadQueueElogio);

		ReceiveMessageRequest receiveRequest = new ReceiveMessageRequest(path);

		while (true) {
			List<Message> messages = sqs.receiveMessage(receiveRequest).getMessages();
			for (Message message : messages) {
				try {
					processarFeedback(message, path);
				} catch (Exception e) {
					log.error("#### Erro ao processar mensagem: {}", e);
					sqsService.publishMessageToSqs(message.getBody(), deadPath);
					sqs.deleteMessage(path, message.getReceiptHandle());
				}
			}
		}
	}
}
