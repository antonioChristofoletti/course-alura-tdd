package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoADesejar() {
        ReajusteService rs = new ReajusteService();
        Funcionario f = new Funcionario("Matias", LocalDate.now(), new BigDecimal("1000"));

        rs.concederReajuste(f, Desempenho.A_DESEJAR);

        Assert.assertEquals(new BigDecimal("1030.00"), f.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoBom() {
        ReajusteService rs = new ReajusteService();
        Funcionario f = new Funcionario("Matias", LocalDate.now(), new BigDecimal("1000"));

        rs.concederReajuste(f, Desempenho.BOM);

        Assert.assertEquals(new BigDecimal("1150.00"), f.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoOtimo() {
        ReajusteService rs = new ReajusteService();
        Funcionario f = new Funcionario("Matias", LocalDate.now(), new BigDecimal("1000"));

        rs.concederReajuste(f, Desempenho.OTIMO);

        Assert.assertEquals(new BigDecimal("1200.00"), f.getSalario());
    }
}