package br.com.ada.cielo.primeirodesafio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.ada.cielo.primeirodesafio.converter.StatusMensagemConverter;
import br.com.ada.cielo.primeirodesafio.converter.TipoFeedbackConverter;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.StatusMensagem;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.TipoFeedback;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerFeedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonDeserialize(converter = TipoFeedbackConverter.class)
	private TipoFeedback tipoFeedback;
	private String mensagem;
	@JsonDeserialize(converter = StatusMensagemConverter.class)
	private StatusMensagem status;

}
