package Deposit.DayPayments.Capitalisation;

import Deposit.DepositCalculator.DepositCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * Тесты для расчета депозита с ежедневными выплатами процентов
 * С капитализацией тип вводимой даты "month"
 * Эталонные значения расчитаны на депозитном калькуляторе с сайта "<a href="https://calcus.ru">calcus.ru</a>"
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */

public class TypeMonthCapitalisationTest {
    /**Tests - Payment type - Month - Capitalisation*/
    @Test
    void typeMonth1CapitalTrue(){
        DepositCalculator DepositCalculator = new DepositCalculator(1, 1, "month", 19, 0, true, LocalDate.of(2024, 1,1), "day");
        DepositCalculator.calculate();
        Assertions.assertEquals(1, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(0, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeMonth2CapitalTrue(){
        DepositCalculator DepositCalculator = new DepositCalculator(1000, 3, "month", 100, 0, true, LocalDate.of(2024, 1,1), "day");
        DepositCalculator.calculate();
        Assertions.assertEquals(1281.83, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(281.83, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(28.18, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeMonth3CapitalTrue(){
        DepositCalculator DepositCalculator = new DepositCalculator(9999, 33, "month", 11, 0, true, LocalDate.of(2024, 1,31), "day");
        DepositCalculator.calculate();
        Assertions.assertEquals(13527.72, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(3528.72, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(35.29, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeMonth4CapitalTrue(){
        DepositCalculator DepositCalculator = new DepositCalculator(999999999, 33, "month", 11, 0, true, LocalDate.of(2024, 12,31), "day");
        DepositCalculator.calculate();
        Assertions.assertEquals(1352870231.16, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(352870232.16, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(35.29, DepositCalculator.getCapitalGains());
    }
//    @Test
//    void typeMonth5CapitalTrue(){
//        DepositCalculator DepositCalculator = new DepositCalculator(999999999, 600, "month", 11, 0, true, LocalDate.of(2024, 12,31), "day");
//        DepositCalculator.calculate();
//        Assertions.assertEquals(244489396945.29, DepositCalculator.getResultDepositAmount());
//        Assertions.assertEquals(243489396946.29, DepositCalculator.getInterestCharges());
//        Assertions.assertEquals(24348.94, DepositCalculator.getCapitalGains());
//    }
    @Test
    void typeMonth6CapitalTrue(){
        DepositCalculator DepositCalculator = new DepositCalculator(999999999, 1, "month", 1, 0, true, LocalDate.of(2024, 7,31), "day");
        DepositCalculator.calculate();
        Assertions.assertEquals( 1000847340.74, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals( 847341.74, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0.08, DepositCalculator.getCapitalGains());
    }
//    @Test
//    void typeMonth7CapitalTrue(){
//        DepositCalculator DepositCalculator = new DepositCalculator(100000000, 600, "month", 100, 0, true, LocalDate.of(2024, 9,22));
//        DepositCalculator.calculate();
//        Assertions.assertEquals( 1001926021966914.0, DepositCalculator.getResultDepositAmount());
//        Assertions.assertEquals( 1001925921966914.0, DepositCalculator.getInterestCharges());
//        Assertions.assertEquals(1001925921.97, DepositCalculator.getCapitalGains());
//    }
}
