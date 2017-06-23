package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		CalculadorDePreco calculador = sessao.getEspetaculo().getTipo().getCalculadoraDePrecos();
		BigDecimal precoUnitario = calculador.calcula(sessao);
		
		return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
	}

}