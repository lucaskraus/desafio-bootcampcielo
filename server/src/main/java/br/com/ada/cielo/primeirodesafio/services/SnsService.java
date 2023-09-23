package br.com.ada.cielo.primeirodesafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;

@Service
public class SnsService {

	private final String PATH_BASE = "arn:aws:sns:%s:%s:%s";
	
	@Autowired
	private AmazonSNS amazonSNS;
	
    @Value("${aws.region}")
    private String region;
    
    @Value("${aws.id.conta}")
    private String idConta;

	public void publishMessageToSnsTopic(String mensagem, String id, String groupID, String topico) {
		
		String pathCompleto = String.format(PATH_BASE, region, idConta, topico); 

		PublishRequest publishRequest = new PublishRequest()//
				.withTopicArn(pathCompleto)//
				.withMessage(mensagem)//
				.withMessageDeduplicationId(id)//
				.withMessageGroupId(groupID);

		amazonSNS.publish(publishRequest);
	}

}
