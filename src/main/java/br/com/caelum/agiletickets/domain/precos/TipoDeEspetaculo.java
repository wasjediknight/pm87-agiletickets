package br.com.caelum.agiletickets.domain.precos;
public enum TipoDeEspetaculo {
	
	CINEMA(new CalculadorDePrecoCinema()), 
	SHOW(new CalculadorDePrecoShow()), 
	TEATRO(new CalculadorDePrecoTeatro()),
	BALLET(new CalculadorDePrecoBallet()),
	ORQUESTRA(new CalculadorDePrecoOrquestra());
	
	private final CalculadoraDePreco calculadorDePreco;
	
	private TipoDeEspetaculo(CalculadoraDePreco calculadorDePreco) {
		this.calculadorDePreco = calculadorDePreco;
	}
	
	public CalculadoraDePreco getCalculadorDePreco() {
		return this.calculadorDePreco;
	}
	
}