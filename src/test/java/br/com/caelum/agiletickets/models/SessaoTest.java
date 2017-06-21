package br.com.caelum.agiletickets.models;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {

	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	
	@Test
	public void DeveVender100ingressoSeHa100vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(100);

		Assert.assertTrue(sessao.podeReservar(100));
	}
	
	@Test
	public void DeveValidarasDatas() throws Exception{
		LocalDate inicio = new LocalDate();
		LocalDate fim = new LocalDate();
		LocalTime hora = new LocalTime();
		
		Periodicidade diaria = Periodicidade.DIARIA;
		
		Espetaculo show = new Espetaculo();
		List<Sessao> sessoes = show.criaSessoes(inicio, fim, hora, diaria);
		
		Assert.assertEquals(1, sessoes.size());
		Sessao unica = sessoes.get(0);
		Assert.assertEquals(show, unica.getEspetaculo());
		Assert.assertEquals(inicio.toDateTime(hora),unica.getInicio());
			
		
	  }
	
}
