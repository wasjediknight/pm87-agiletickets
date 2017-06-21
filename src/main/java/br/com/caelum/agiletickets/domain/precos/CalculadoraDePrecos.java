package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculadoraDePrecos {

	public BigDecimal calcula(Sessao sessao, Integer quantidade) {
		CalculadoraDePreco calculador = sessao.getEspetaculo().getTipo().getCalculadorDePreco();
		BigDecimal precoUnitario = calculador.calcula(sessao);
		
		return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
	}

}