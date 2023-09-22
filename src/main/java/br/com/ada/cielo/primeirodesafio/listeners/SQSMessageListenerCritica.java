package br.com.ada.cielo.primeirodesafio.listeners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

@Component
public class SQSMessageListenerCritica implements ApplicationListener<ContextRefreshedEvent> {

	private final AmazonSQS sqs;
	private final String queueUrl;

	@Autowired
	public SQSMessageListenerCritica(AmazonSQS sqs) {
		this.sqs = sqs;
		this.queueUrl = "https://sqs.us-east-1.amazonaws.com/352245087617/sqs-critica.fifo";
	}

	@Async
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		while (true) {
			try {
				ReceiveMessageRequest receiveRequest = new ReceiveMessageRequest(queueUrl);

				List<Message> messages = sqs.receiveMessage(receiveRequest).getMessages();

				for (Message message : messages) {
					System.out.println("Mensagem: " + message.getBody());
					sqs.deleteMessage(queueUrl, message.getReceiptHandle());
				}

				Thread.sleep(5000);
			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
		}
	}

}
