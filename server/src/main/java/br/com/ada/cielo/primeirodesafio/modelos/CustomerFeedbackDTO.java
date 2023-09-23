package br.com.ada.cielo.primeirodesafio.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFeedbackDTO {
	
	private String mensagem;
	private String tipoFeedback;

}
