package br.com.caelum.agiletickets.domain.precos;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Weeks;

import br.com.caelum.agiletickets.models.Espetaculo;
import br.com.caelum.agiletickets.models.Sessao;

public class CriadorDeSessoesSemanal implements CriadorDeSessoes {

	@Override
	public List<Sessao> criaSessoes(LocalDate inicio, LocalDate fim, LocalTime horario, Espetaculo espetaculo) {
		List<Sessao> sessoes = new ArrayList<Sessao>();
		
		int semanas = Weeks.weeksBetween(inicio, fim).getWeeks();
		for (int i = 0; i < semanas; i++) {
			Sessao sessao = new Sessao();
			sessao.setEspetaculo(espetaculo);
			
			DateTime dataDaSessao = inicio.plusWeeks(i).toDateTime(horario);
			sessao.setInicio(dataDaSessao);
			
			sessoes.add(sessao);
		}
		
		return sessoes;
	}

}