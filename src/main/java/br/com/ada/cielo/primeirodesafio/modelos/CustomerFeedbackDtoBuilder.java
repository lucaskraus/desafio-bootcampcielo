package br.com.ada.cielo.primeirodesafio.modelos;

import br.com.ada.cielo.primeirodesafio.entities.CustomerFeedback;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.StatusMensagem;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.TipoFeedback;

public class CustomerFeedbackDtoBuilder {
	
	public CustomerFeedbackDtoBuilder() {
		super();
	}
	
	public static CustomerFeedbackDto build(CustomerFeedback entity) {
		return CustomerFeedbackDto.builder()//
				.tipoFeedback(entity.getTipoFeedback().getDescricao())//
				.mensagem(entity.getMensagem())//
				.status(entity.getStatus().getDescricao())//
				.build();
	}
	
	public static CustomerFeedback buildBack(CustomerFeedbackDto dto) {
		return CustomerFeedback.builder()//
				.tipoFeedback(TipoFeedback.getEnum(dto.getTipoFeedback()))//
				.mensagem(dto.getMensagem())//
				.status(StatusMensagem.RECEBIDO)//
				.build();
	}
	

}
