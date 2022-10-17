package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReajusteServiceTest {
    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }


    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        this.reajusteService.concederReajuste(this.funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), this.funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForBom() {
        this.reajusteService.concederReajuste(this.funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), this.funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForOtimo() {
        this.reajusteService.concederReajuste(this.funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), this.funcionario.getSalario());
    }
}
