package br.com.ada.cielo.primeirodesafio.modelos;

import br.com.ada.cielo.primeirodesafio.modelos.enuns.TipoFeedback;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFeedbackResumoVO {
	
    private String tipoFeedback;
    private long recebido;
    private long emProcessamento;
    private long finalizado;
    private long total;
    
    public CustomerFeedbackResumoVO(TipoFeedback tipoFeedback, long recebido, long emProcessamento, long finalizado, long total) {
        this.tipoFeedback = tipoFeedback.getDescricao();
        this.recebido = recebido;
        this.emProcessamento = emProcessamento;
        this.finalizado = finalizado;
        this.total = total;
    }

}
