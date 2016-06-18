package br.com.caelum.agiletickets.acceptance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import br.com.caelum.agiletickets.acceptance.page.ReservasPage;

public class ReservaTest {

	private WebDriver browser;
	
	@Before
	public void setUp() throws Exception {
		browser = new HtmlUnitDriver();
	}
	
	@After
	public void tearDown() {
		browser.close();
	}
	
	@Test
	public void deveReservarIngressoMaisCaro() {
		ReservasPage paginaReservas = new ReservasPage(browser);
		
		paginaReservas.abreSessaoComCincoIngressosRestantes();
		paginaReservas.reservaUmIngresso();
		paginaReservas.verificaAcrescimoDeDezPorcento();		
		
	}
	
	//sessao ja cadastrada com total de ingressos 100, 95 reservados. 50 reais
	//reservar 1 ingresso
	//preco deve ser 55 (original mais 10por cento)
	
}
