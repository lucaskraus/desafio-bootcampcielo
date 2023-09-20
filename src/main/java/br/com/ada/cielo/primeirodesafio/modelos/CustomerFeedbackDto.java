package br.com.ada.cielo.primeirodesafio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFeedbackDto {
	
	private Long id;
	private String tipoFeedback;
	private String mensagem;
	private String status;

}
