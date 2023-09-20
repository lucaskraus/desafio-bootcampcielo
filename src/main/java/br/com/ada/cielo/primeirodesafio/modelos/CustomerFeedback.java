package br.com.ada.cielo.primeirodesafio.modelos;

import br.com.ada.cielo.primeirodesafio.modelos.enuns.StatusMensagem;
import br.com.ada.cielo.primeirodesafio.modelos.enuns.TipoFeedback;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFeedback {
	
	private Long id;
	private TipoFeedback tipoFeedback;
	private String mensagem;
	private StatusMensagem status;

}
