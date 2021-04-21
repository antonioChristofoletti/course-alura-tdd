package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
//        Assert.assertThrows(IllegalArgumentException.class, () -> {
//            BonusService bs = new BonusService();
//            bs.calcularBonus(new Funcionario("Jake", LocalDate.now(), new BigDecimal("25000")));
//        });


        try {
            BonusService bs = new BonusService();
            bs.calcularBonus(new Funcionario("Jake", LocalDate.now(), new BigDecimal("25000")));
            Assert.fail("Nâo deu a exception");
        } catch (Exception e) {
        }
    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService bs = new BonusService();
        BigDecimal bonus = bs.calcularBonus(new Funcionario("Jake", LocalDate.now(), new BigDecimal("2500")));

        Assert.assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    public void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BonusService bs = new BonusService();
        BigDecimal bonus = bs.calcularBonus(new Funcionario("Jake", LocalDate.now(), new BigDecimal("10000")));

        Assert.assertEquals(new BigDecimal("1000.0"), bonus);
    }
}
