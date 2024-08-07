package Deposit.MonthPayments.WihoutCapitalisation;

import Deposit.DepositCalculator.DepositCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * Тесты для расчета депозита с ежемесячными выплатами процентов.
 * Без капитализации.
 * Эталонные значения расчитаны на депозитном калькуляторе с сайта "<a href="https://calcus.ru">calcus.ru</a>"
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */

public class MonthlyPaymentsNoCapitalisationTests {

    @Test
    public void DepositCalculatorNoCapitalisationMonth1() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 1, "month", 12, 0, false, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(10101.64, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(101.64, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(1.02, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorNoCapitalisationMonth2() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 1, "month", 12, 0, false, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(10101.64, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(101.64, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(1.02, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorNoCapitalisationMonth3() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 10, "month", 12, 0, false, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(11000, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(1000, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(10, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorNoCapitalisationMonth4() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 12, "month", 12, 0, false, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(11200.01, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(1200.01, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(12, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorNoCapitalisationMonth5() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 14, "month", 12, 0, false, LocalDate.of(2024, 1,9), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(11394.05, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(1394.05, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(13.94, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorNoCapitalisationMonth6() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 2, "month", 12, 0, false, LocalDate.of(2024, 1,9), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(10196.72, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(196.72, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(1.97, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorNoCapitalisationMonth7() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 2, "month", 12, 0, false, LocalDate.of(2024, 12,15), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(10203.69, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(203.69, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(2.04, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorNoCapitalisationMonth8() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 300, "month", 6, 0, false, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(25000.48, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(15000.48, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(150, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorNoCapitalisationMonth9() {
        DepositCalculator DepositCalculator = new DepositCalculator(10000000, 600, "month", 6, 0, false, LocalDate.of(2024, 1,1), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(40000003.62, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(30000003.62, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(300, DepositCalculator.getCapitalGains());
    }
    @Test
    public void DepositCalculatorNoCapitalisationMonth10() {
        DepositCalculator DepositCalculator = new DepositCalculator(100000000, 600, "month", 100, 0, false, LocalDate.of(2024, 12,12), "month");
        DepositCalculator.calculate();
        Assertions.assertEquals(5099985776.22 , DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(4999985776.22, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(4999.99, DepositCalculator.getCapitalGains());
    }
}
