package br.com.ada.cielo.primeirodesafio.modelos.enuns;

public enum TipoFeedback {
	
	CRITICA("C", "Crítica"),
	ELOGIO("E", "Elogio"),
	SUGESTAO("S", "Sugestão");
	
	private String codigo;
	private String descricao;
	
	TipoFeedback(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoFeedback getEnum(String codigo) {
		for(TipoFeedback tipo : TipoFeedback.values()) {
			if(tipo.codigo.equals(codigo)) {
				return tipo;
			}
		}
		return null;
	}
	
	

}
