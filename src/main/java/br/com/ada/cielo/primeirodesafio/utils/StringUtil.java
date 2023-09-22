package br.com.ada.cielo.primeirodesafio.utils;

import java.text.Normalizer;

public class StringUtil {
	
	public static String removerremoverAcentos(String texto) {
		
        String normalized = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return normalized.replaceAll("[^\\p{ASCII}]", "").toLowerCase();
	}
	
	
}
