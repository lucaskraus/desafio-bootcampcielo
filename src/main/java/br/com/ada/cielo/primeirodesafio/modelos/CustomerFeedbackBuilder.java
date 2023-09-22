package br.com.ada.cielo.primeirodesafio.modelos;

import br.com.ada.cielo.primeirodesafio.entities.CustomerFeedback;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.StatusMensagem;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.TipoFeedback;

public class CustomerFeedbackBuilder {
	
	public CustomerFeedbackBuilder() {
		super();
	}
	
	public static CustomerFeedbackVO buildVO(CustomerFeedback entity) {
		return CustomerFeedbackVO.builder()//
				.tipoFeedback(entity.getTipoFeedback().getDescricao())//
				.mensagem(entity.getMensagem())//
				.status(entity.getStatus().getDescricao())//
				.build();
	}
	
	public static CustomerFeedback buildEntity(CustomerFeedbackDTO dto, StatusMensagem status) {
		return CustomerFeedback.builder()//
				.tipoFeedback(TipoFeedback.getEnum(dto.getTipoFeedback().toUpperCase()))//
				.mensagem(dto.getMensagem())//
				.status(status)//
				.build();
	}
	

}
