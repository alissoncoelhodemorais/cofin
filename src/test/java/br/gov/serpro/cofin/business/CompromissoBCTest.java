package br.gov.serpro.cofin.business;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.serpro.cofin.domain.Compromisso;

@RunWith(DemoiselleRunner.class)
public class CompromissoBCTest {

	@Test
	public void testDomainIsAtrasado() {
		boolean retorno = false;
		
		Compromisso comp = new Compromisso();
		Date dataVencimento = new Date(new Date().getTime()-100000);
		System.out.println(dataVencimento.toString());
		comp.setDataVencimento(dataVencimento);
		
		retorno = comp.isAtrasado();
		
		assertTrue(retorno);
	}
}
