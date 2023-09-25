package br.com.ada.cielo.primeirodesafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;

@Service
public class SqsService {

	@Autowired
	private AmazonSQS sqs;


	public void publishMessageToSqs(String mensagem, String url) {
        SendMessageRequest sendRequest = new SendMessageRequest()
                .withQueueUrl(url)
                .withMessageBody(mensagem);

            sqs.sendMessage(sendRequest);
	}

}
