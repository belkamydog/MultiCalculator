package Deposit.DayPayments.WithoutCapitalisation;


import Deposit.DepositCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * Тесты для расчета депозита с ежедневными выплатами процентов
 * Без капитализации тип вводимой даты Deposit.DepositCalculator.termSelect.month
 * Эталонные значения расчитаны на депозитном калькуляторе с сайта "<a href="https://calcus.ru">...</a>"
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */
public class TypeMonthNoCapitalisationTests {
    /**Tests - Payment type - Month - No capitalisation*/
    @Test
    void typeMonth1CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(1, 1, Deposit.DepositCalculator.termSelect.month, 19, 0, false, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(0, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeMonth2CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(1000, 3, Deposit.DepositCalculator.termSelect.month, 100, 0, false, LocalDate.of(2024, 1,1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1248.43, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(248.43, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(24.84, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeMonth3CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(9999, 33, Deposit.DepositCalculator.termSelect.month, 11, 0, false, LocalDate.of(2024, 1,31), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(13021.04, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(3022.04, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(30.22, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeMonth4CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(999999999, 33, Deposit.DepositCalculator.termSelect.month, 11, 0, false, LocalDate.of(2024, 12,31), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1302273968.58, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(302273969.58, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(30.23, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeMonth5CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(999999999, 600, Deposit.DepositCalculator.termSelect.month, 11, 0, false, LocalDate.of(2024, 12,31), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(6499999965.6, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(5499999966.6, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(550, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeMonth6CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(999999999, 1, Deposit.DepositCalculator.termSelect.month, 1, 0, false, LocalDate.of(2024, 7,31), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1000846993.4 , DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(846994.4 , DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0.08, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeMonth7CapitalFalse(){
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 600, Deposit.DepositCalculator.termSelect.month, 100, 0, false, LocalDate.of(2024, 9,22), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals( 50999251489.58, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals( 49999251489.58, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(4999.93, DepositCalculator.getCapitalGains());
    }
}
