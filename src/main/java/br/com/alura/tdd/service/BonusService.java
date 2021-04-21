package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcionário com salário com mais de 1000 não recebe bonûs");
		}
		return valor;
	}

}
