package br.com.ada.cielo.primeirodesafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;

@Service
public class SnsService {
	
	@Autowired
	private AmazonSNS amazonSNS;

	public void publishMessageToSnsTopic(String topicArn, String message, String messageGroupId) {
		PublishRequest publishRequest = new PublishRequest().withTopicArn(topicArn).withMessage(message)
				.withMessageDeduplicationId(messageGroupId).withMessageGroupId("1223");

		amazonSNS.publish(publishRequest);
	}

}
