package Deposit.DayPayments.WithoutCapitalisation;

import Deposit.DepositCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * Тесты для расчета депозита с ежедневными выплатами процентов
 * Без капитализации тип вводимой даты Deposit.DepositCalculator.termSelect.year
 * Эталонные значения расчитаны на депозитном калькуляторе с сайта "<a href="https://calcus.ru">calcus.ru</a>"
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */
public class TypeYearNoCapitalisationTests {
    /**Tests - Payment type - Month - No capitalisation*/
    @Test
    void typeYear1CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(1, 1, Deposit.DepositCalculator.termSelect.year, 19, 0, false, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(0, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeYear2CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 1, Deposit.DepositCalculator.termSelect.year, 19, 0, false, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(11899.56, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(1899.56, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(19, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeYear3CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 1, Deposit.DepositCalculator.termSelect.year, 100, 0, false, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(2000007486.63, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(1000007486.63, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(100, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeYear4CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 2, Deposit.DepositCalculator.termSelect.year, 100, 0, false, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(3000007487.58, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(2000007487.58, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(200, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeYear5CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 50, Deposit.DepositCalculator.termSelect.year, 100, 0, false, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(51000007534.26, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(50000007534.26, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(5000, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeYear6CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 3, Deposit.DepositCalculator.termSelect.year, 6, 0, false, LocalDate.of(2024, 3,25), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(11795.8, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(1795.8, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(17.96, DepositCalculator.getCapitalGains());
    }
}
