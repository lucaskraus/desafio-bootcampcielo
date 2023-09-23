package br.com.ada.cielo.primeirodesafio.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

import br.com.ada.cielo.primeirodesafio.modelos.enuns.TipoFeedback;

public class TipoFeedbackConverter implements Converter<String, TipoFeedback> {

	@Override
	public TipoFeedback convert(String value) {
		return TipoFeedback.getEnum(value);
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return typeFactory.constructType(String.class);
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return typeFactory.constructType(TipoFeedback.class);
	}

}
