package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService rs = new ReajusteService();
    private Funcionario f = new Funcionario("Matias", LocalDate.now(), new BigDecimal("1000"));

    @BeforeAll
    public static void inicializarTodos() {
        System.out.println("inicializar todos");
    }

    @AfterAll
    public static void finalizarTodos() {
        System.out.println("Fim todos");
    }

    @BeforeEach
    private void inicializar() {
        System.out.println("inicializar cada");
        rs = new ReajusteService();
        f = new Funcionario("Matias", LocalDate.now(), new BigDecimal("1000"));
    }

    @AfterEach
    public void finalizar() {
        System.out.println("Fim cada");
    }

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoADesejar() {
        rs.concederReajuste(f, Desempenho.A_DESEJAR);
        Assertions.assertEquals(new BigDecimal("1030.00"), f.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoBom() {
        rs.concederReajuste(f, Desempenho.BOM);
        Assertions.assertEquals(new BigDecimal("1150.00"), f.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoOtimo() {
        rs.concederReajuste(f, Desempenho.OTIMO);
        Assertions.assertEquals(new BigDecimal("1200.00"), f.getSalario());
    }
}