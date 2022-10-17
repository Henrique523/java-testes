package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			valor = BigDecimal.ZERO;
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal percentualReajuste = desempenho.percentualReajuste();
		BigDecimal reajuste = funcionario.getSalario().multiply(percentualReajuste);
		funcionario.reajustarSalario(reajuste);
	}
}
