package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario f, Desempenho desempenho) {
        BigDecimal valorReajuste = desempenho.percentualReajuste().multiply(f.getSalario());
        f.reajustarSalario(valorReajuste);
    }
}