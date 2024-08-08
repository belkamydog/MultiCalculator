package Deposit.YearPayment.WithoutCapitalisation;

import Deposit.DepositCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * Тесты для расчета депозита с ежегодными выплатами процентов.
 * Без капитализации.
 * Эталонные значения расчитаны на депозитном калькуляторе с сайта "<a href="https://calcus.ru">calcus.ru</a>"
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */

public class YearPaymentNoCapitalisationTests {
        @Test
        public void typeDateYearNoCapitalisation1() {
            DepositCalculator DepositCalculator = new DepositCalculator(10000, 1, Deposit.DepositCalculator.termSelect.year, 12, 0, false, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.year);
            DepositCalculator.calculate();
            Assertions.assertEquals(11200.01, DepositCalculator.getResultDepositAmount());
            Assertions.assertEquals(1200.01, DepositCalculator.getInterestCharges());
            Assertions.assertEquals(12, DepositCalculator.getCapitalGains());
        }
    @Test
    public void typeDateYearNoCapitalisation2() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 2, Deposit.DepositCalculator.termSelect.year, 12, 0, false, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.year);
        DepositCalculator.calculate();
        Assertions.assertEquals(12400.01, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(2400.01, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(24, DepositCalculator.getCapitalGains());
    }
    @Test
    public void typeDateYearNoCapitalisation3() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 5, Deposit.DepositCalculator.termSelect.year, 12, 0, false, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.year);
        DepositCalculator.calculate();
        Assertions.assertEquals(16000.01, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(6000.01, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(60, DepositCalculator.getCapitalGains());
    }
    @Test
    public void typeDateYearNoCapitalisation4() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000, 30, Deposit.DepositCalculator.termSelect.year, 10, 0, false, LocalDate.of(2024, 2,1), Deposit.DepositCalculator.termSelect.year);
        DepositCalculator.calculate();
        Assertions.assertEquals(4000023.95, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(3000023.95, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(300, DepositCalculator.getCapitalGains());
    }
    @Test
    public void typeDateYearNoCapitalisation5() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000, 1, Deposit.DepositCalculator.termSelect.year, 10, 0, false, LocalDate.of(2024, 2,29), Deposit.DepositCalculator.termSelect.year);
        DepositCalculator.calculate();
        Assertions.assertEquals(1100044.91, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(100044.91, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(10, DepositCalculator.getCapitalGains());
    }
    @Test
    public void typeDateYearNoCapitalisation6() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000, 5, Deposit.DepositCalculator.termSelect.year, 10, 0, false, LocalDate.of(2024, 2,29), Deposit.DepositCalculator.termSelect.year);
        DepositCalculator.calculate();
        Assertions.assertEquals(1500044.91, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(500044.91, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(50, DepositCalculator.getCapitalGains());
    }
    @Test
    public void typeDateYearNoCapitalisation7() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000, 10, Deposit.DepositCalculator.termSelect.day, 10, 0, false, LocalDate.of(2024, 2,29), Deposit.DepositCalculator.termSelect.year);
        DepositCalculator.calculate();
        Assertions.assertEquals(1002732.24, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(2732.24, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0.27, DepositCalculator.getCapitalGains());
    }
    @Test
    public void typeDateYearNoCapitalisation8() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000, 10, Deposit.DepositCalculator.termSelect.month, 10, 0, false, LocalDate.of(2024, 2,29), Deposit.DepositCalculator.termSelect.year);
        DepositCalculator.calculate();
        Assertions.assertEquals(1083060.11, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(83060.11, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(8.31, DepositCalculator.getCapitalGains());
    }

    @Test
    public void typeDateYearNoCapitalisation9() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000, 10, Deposit.DepositCalculator.termSelect.month, 10, 0, false, LocalDate.of(2024, 12,29), Deposit.DepositCalculator.termSelect.year);
        DepositCalculator.calculate();
        Assertions.assertEquals(1083286.17, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(83286.17, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(8.33, DepositCalculator.getCapitalGains());
    }
}
