package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	private static final double CINCO_POR_CENTO = 5;
	private static final double DEZ_POR_CENTO = 10;
	private static final double VINTE_POR_CENTO = 20;
	private static final double CINQUENTA_POR_CENTO = 50;

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco = sessao.getPreco();
		
		if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.CINEMA) 
				|| sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.SHOW)) {
			//quando estiver acabando os ingressos... 
			if(sessao.isUltimosIngressos(CINCO_POR_CENTO)) { 
				preco = sessao.getPrecoAumentado(DEZ_POR_CENTO);
			} 
			
		} else if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.BALLET)
				|| sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.ORQUESTRA)) {
			if(sessao.isUltimosIngressos(CINQUENTA_POR_CENTO)) { 
				preco = sessao.getPrecoAumentado(VINTE_POR_CENTO);
			}
			
			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(sessao.calculaAcrescimo(DEZ_POR_CENTO));
			}
		}

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

}