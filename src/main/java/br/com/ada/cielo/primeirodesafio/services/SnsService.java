package br.com.ada.cielo.primeirodesafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ada.cielo.primeirodesafio.entities.CustomerFeedback;
import br.com.ada.cielo.primeirodesafio.utils.StringUtil;

@Service
public class SnsService {
	
	private final String TOPIC_ARN = "arn:aws:sns:us-east-1:352245087617:sns-%s.fifo";
	
	@Autowired
	private AmazonSNS amazonSNS;

	public void publishMessageToSnsTopic(CustomerFeedback mensagem) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String topico = StringUtil.removerremoverAcentos(mensagem.getTipoFeedback().getDescricao());
		
		PublishRequest publishRequest = new PublishRequest()//
				.withTopicArn(String.format(TOPIC_ARN, topico))//
				.withMessage(objectMapper.writeValueAsString(mensagem))//
				.withMessageDeduplicationId(mensagem.getId().toString())//
				.withMessageGroupId(topico + "352245087617");
		
		amazonSNS.publish(publishRequest);
	}

}
