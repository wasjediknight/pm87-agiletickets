package br.com.caelum.agiletickets.domain.precos;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import br.com.caelum.agiletickets.models.Espetaculo;
import br.com.caelum.agiletickets.models.Sessao;

public class CriadorDeSessoesDiaria implements CriadorDeSessoes {

	@Override
	public List<Sessao> criaSessoes(LocalDate inicio, LocalDate fim, LocalTime horario, Espetaculo espetaculo) {
		List<Sessao> sessoes = new ArrayList<Sessao>();
		
		int dias = Days.daysBetween(inicio, fim).getDays();
		for (int i = 0; i < dias; i++) {
			Sessao sessao = new Sessao();
			sessao.setEspetaculo(espetaculo);
			
			DateTime dataDaSessao = inicio.plusDays(i).toDateTime(horario);
			sessao.setInicio(dataDaSessao);
			
			sessoes.add(sessao);
		}
		
		return sessoes;
	}

}