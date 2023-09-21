package br.com.ada.cielo.primeirodesafio.modelos.enuns;

public enum StatusMensagem {
	
	RECEBIDO("R", "Recebido"),
	EM_PROCESSAMENTO("P", "Em Processamento"),
	FINALIZADO("F", "Finalizado");
	
	private String codigo;
	private String descricao;
	
	StatusMensagem(String codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static StatusMensagem getEnum(String codigo) {
		for(StatusMensagem status : StatusMensagem.values()) {
			if(status.codigo.equals(codigo)) {
				return status;
			}
		}
		return null;
	}

}
