package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService bonusService = new BonusService();
//        assertThrows(IllegalArgumentException.class,
//                () -> bonusService.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("25000"))));

        try {
            bonusService.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("25000")));
            fail("Não deu a exception");
        } catch (Exception e) {
            assertEquals("Funcionario com salário maior que 10000 reais não pode receber bonus", e.getMessage());
        }

    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveSerMilParaLimiteDe10Mil() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}