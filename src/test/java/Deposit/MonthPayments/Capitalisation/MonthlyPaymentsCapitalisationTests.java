package Deposit.MonthPayments.Capitalisation;

import Deposit.DepositCalculator.DepositCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * Тесты для расчета депозита с ежемесячными выплатами процентов.
 * С капитализацией.
 * Эталонные значения расчитаны на депозитном калькуляторе с сайта "<a href="https://calcus.ru">calcus.ru</a>"
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */

public class MonthlyPaymentsCapitalisationTests {

    @Test
    public void DepositCalculatorCapitalisationMonth1() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 1, "month", 12, 0, true, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(10101.64, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(101.64, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(1.02, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorCapitalisationMonth2() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 6, "month", 12, 0, true, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(10611.75, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(611.75, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(6.12, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorCapitalisationMonth3() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 10, "month", 12, 0, true, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(11046.21, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(1046.21, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(10.46, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorCapitalisationMonth4() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 12, "month", 12, 0, true, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(11268.25, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(1268.25, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(12.68, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorNoCapitalisationMonth5() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 14, "month", 12, 0, true, LocalDate.of(2024, 1,9), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(11487.96, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(1487.96, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(14.88, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorCapitalisationMonth6() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 2, "month", 12, 0, true, LocalDate.of(2024, 1,9), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(10197.69, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(197.69, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(1.98, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorCapitalisationMonth7() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 2, "month", 12, 0, true, LocalDate.of(2024, 12,15), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(10204.73, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(204.73, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(2.05, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorCapitalisationMonth8() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 300, "month", 6, 0, true, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(44649.74, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(34649.74, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(346.5, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorCapitalisationMonth9() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000000, 600, "month", 6, 0, true, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(199358590.75, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(189358590.75, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(1893.59, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorCapitalisationMonthIfTermLessThenMonth() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 15, "day", 10, 0, true, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(10040.98, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(40.98, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0.41, DepositCalculator.getCapitalGains());
    }
}
