package br.com.ada.cielo.primeirodesafio.modelos;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ada.cielo.primeirodesafio.entities.CustomerFeedback;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.StatusMensagem;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.TipoFeedback;

public class CustomerFeedbackBuilder {

	public CustomerFeedbackBuilder() {
		super();
	}

	public static CustomerFeedbackVO buildVO(CustomerFeedback entity) {
		return CustomerFeedbackVO.builder()//
				.id(entity.getId())//
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

	public static List<CustomerFeedbackVO> buildVO(List<CustomerFeedback> list) {
		if (list == null) return null;

		return list.stream()//
				.map(CustomerFeedbackBuilder::buildVO)//
				.collect(Collectors.toList());
	}

}
