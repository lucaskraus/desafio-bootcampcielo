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
public class SQSMessageListenerCritica extends AbstractSQSMessageListener {

	@Value("${aws.queue.critica}")
	private String queueCritica;

	@Value("${aws.queue.dead.critica}")
	private String deadQueueCritica;

	@Async
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		String path = getPath(queueCritica);
		String deadPath = getPath(deadQueueCritica);

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
