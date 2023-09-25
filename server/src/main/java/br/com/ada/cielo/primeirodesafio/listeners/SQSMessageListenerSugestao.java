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
public class SQSMessageListenerSugestao extends AbstractSQSMessageListener {

	@Value("${aws.queue.sugestao}")
	private String queueSugestao;

	@Value("${aws.queue.dead.sugestao}")
	private String deadQueueSugestao;

	@Async
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		String path = getPath(queueSugestao);
		String deadPath = getPath(deadQueueSugestao);

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
