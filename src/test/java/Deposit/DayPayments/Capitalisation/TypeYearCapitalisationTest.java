package Deposit.DayPayments.Capitalisation;


import Deposit.DepositCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * Тесты для расчета депозита с ежедневными выплатами процентов.
 * С капитализацией. Тип вводимой даты Deposit.DepositCalculator.termSelect.year.
 * Эталонные значения расчитаны на депозитном калькуляторе с сайта "<a href="https://calcus.ru">calcus.ru</a>"
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */
public class TypeYearCapitalisationTest {
    /**Tests - Payment type - Month - Capitalisation*/
    @Test
    void typeYear1CapitalTrue(){
        DepositCalculator DepositCalculator = new DepositCalculator(1, 1, Deposit.DepositCalculator.termSelect.year, 19, 0, true, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(0, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeYear2CapitalTrue(){
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 1, Deposit.DepositCalculator.termSelect.year, 19, 0, true, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(12091.92, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(2091.92, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(20.92, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeYear3CapitalTrue(){
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 1, Deposit.DepositCalculator.termSelect.year, 100, 0, true, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(2714597870.11, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(1714597870.11 , DepositCalculator.getInterestCharges());
        Assertions.assertEquals(171.46, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeYear4CapitalTrue(){
        DepositCalculator DepositCalculator = new DepositCalculator(10000, 2, Deposit.DepositCalculator.termSelect.year, 12, 0, true, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(12711.98, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(2711.98 , DepositCalculator.getInterestCharges());
        Assertions.assertEquals(27.12, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeYear5CapitalTrue(){
        DepositCalculator DepositCalculator = new DepositCalculator(100000, 2, Deposit.DepositCalculator.termSelect.year, 100, 0, true, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(736895.64, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(636895.64, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(636.9, DepositCalculator.getCapitalGains());
    }
    /**Разница с calcus -13 копеек*/
    @Test
    void typeYear6CapitalTrue(){
        DepositCalculator DepositCalculator = new DepositCalculator(100000, 50, Deposit.DepositCalculator.termSelect.year, 3, 0, true, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(448141.19, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(348141.19, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(348.14, DepositCalculator.getCapitalGains());
    }
    @Test
    void changeStatTableBalanceTest(){
        DepositCalculator depositCalculator = new DepositCalculator(10000, 5, Deposit.DepositCalculator.termSelect.year, 12, 0, true, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        depositCalculator.calculate();
    }
}
