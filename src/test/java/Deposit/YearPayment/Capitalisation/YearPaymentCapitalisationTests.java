package Deposit.YearPayment.Capitalisation;

import Deposit.DepositCalculator.DepositCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * Тесты для расчета депозита с ежегодными выплатами процентов.
 * С капитализацией.
 * Эталонные значения расчитаны на депозитном калькуляторе с сайта "<a href="https://calcus.ru">calcus.ru</a>"
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */

public class YearPaymentCapitalisationTests {
    @Test
    public void typeDateYearCapitalisation1() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 1, "year", 12, 0, true, LocalDate.of(2024, 1,1), "year");
        DepositCalculator.calculate();
        Assertions.assertEquals(11200.01, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(1200.01, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(12, DepositCalculator.getCapitalGains());
    }
    @Test
    public void typeDateYearCapitalisation2() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 2, "year", 12, 0, true, LocalDate.of(2024, 1,1), "year");
        DepositCalculator.calculate();
        Assertions.assertEquals(12544.01, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(2544.01, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(25.44, DepositCalculator.getCapitalGains());
    }
    @Test
    public void typeDateYearCapitalisation3() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 5, "year", 12, 0, true, LocalDate.of(2024, 1,1), "year");
        DepositCalculator.calculate();
        Assertions.assertEquals(17623.43, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(7623.43, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(76.23, DepositCalculator.getCapitalGains());
    }
//    @Test
//    public void typeDateYearCapitalisation4() {
//        DepositCalculator DepositCalculator = new DepositCalculator(1000000, 30, "year", 10, 0, true, LocalDate.of(2024, 2,1));
//        DepositCalculator.calculate();
//        DepositCalculator.printYearsStat();
//        Assertions.assertEquals(17449782.3, DepositCalculator.getResultDepositAmount());
//        Assertions.assertEquals(16449782.3, DepositCalculator.getInterestCharges());
//        Assertions.assertEquals(1644.98, DepositCalculator.getCapitalGains());
//    }
    @Test
    public void typeDateYearCapitalisation5() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000, 1, "year", 10, 0, true, LocalDate.of(2024, 2,29), "year");
        DepositCalculator.calculate();
        Assertions.assertEquals(1100044.91, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(100044.91, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(10, DepositCalculator.getCapitalGains());
    }
    @Test
    public void typeDateYearCapitalisation6() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 5, "year", 12, 0, true, LocalDate.of(2024, 2,29), "year");
        DepositCalculator.calculate();
        Assertions.assertEquals(17624.25, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(7624.25, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(76.24, DepositCalculator.getCapitalGains());
    }
    @Test
    public void typeDateYearCapitalisation7() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000, 10, "day", 10, 0, true, LocalDate.of(2024, 2,29), "year");
        DepositCalculator.calculate();
        Assertions.assertEquals(1002732.24, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(2732.24, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0.27, DepositCalculator.getCapitalGains());
    }
    @Test
    public void typeDateYearCapitalisation8() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000, 10, "month", 10, 0, true, LocalDate.of(2024, 2,29), "year");
        DepositCalculator.calculate();
        Assertions.assertEquals(1083060.11 , DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(83060.11, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(8.31, DepositCalculator.getCapitalGains());
    }

    @Test
    public void typeDateYearCapitalisation9() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000, 10, "month", 10, 0, true, LocalDate.of(2024, 12,29), "year");
        DepositCalculator.calculate();
        Assertions.assertEquals(1083286.17, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(83286.17, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(8.33, DepositCalculator.getCapitalGains());
    }

    @Test
    public void typeDateYearCapitalisation10() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 20, "year", 12, 0, true, LocalDate.of(2024, 2,29), "year");
        DepositCalculator.calculate();
        Assertions.assertEquals(96462.84, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(86462.84, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(864.63, DepositCalculator.getCapitalGains());
    }
}
