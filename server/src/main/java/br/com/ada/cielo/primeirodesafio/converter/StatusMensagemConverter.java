package br.com.ada.cielo.primeirodesafio.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

import br.com.ada.cielo.primeirodesafio.modelos.enuns.StatusMensagem;

public class StatusMensagemConverter implements Converter<String, StatusMensagem> {

	@Override
	public StatusMensagem convert(String value) {
		return StatusMensagem.getEnum(value);
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return typeFactory.constructType(String.class);
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return typeFactory.constructType(StatusMensagem.class);
	}

}
