package br.gov.serpro.cofin.config;

import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(resource="cofin")
public class CofinConfig {
	
	private int valorMinimo;

	public int getValorMinimo() {
		return valorMinimo;
	}

}
