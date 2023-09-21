package br.com.ada.cielo.primeirodesafio.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFeedbackDto {
	
	private Long id;
	private String tipoFeedback;
	private String mensagem;
	private String status;

}
