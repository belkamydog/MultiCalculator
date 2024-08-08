package Deposit.DayPayments.WithoutCapitalisation;

import Deposit.DepositCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
/**
 * Тесты для расчета депозита с ежедневными выплатами процентов
 * Без капитализации тип вводимой даты Deposit.DepositCalculator.termSelect.day
 * Эталонные значения расчитаны на депозитном калькуляторе с сайта "<a href="https://calcus.ru">...</a>"
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */
public class TypeDayNoCapitalisationTests {
    /**
     * Tests - Payment type - Day - No capitalisation
     */
    @Test
    void typeDay1dayCapitalFalse() {
        DepositCalculator DepositCalculator = new DepositCalculator(1, 1, Deposit.DepositCalculator.termSelect.day, 12, 0, false, LocalDate.of(2024, 1, 1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(0, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay2dayCapitalFalse() {
        DepositCalculator DepositCalculator = new DepositCalculator(1, 10, Deposit.DepositCalculator.termSelect.day, 12, 0, false, LocalDate.of(2024, 3, 12), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(0, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay3dayCapitalFalse() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000, 10, Deposit.DepositCalculator.termSelect.day, 12, 0, false, LocalDate.of(2024, 3, 12), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1003.3, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(3.3, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0.33, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay4dayCapitalFalse() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000, 1000, Deposit.DepositCalculator.termSelect.day, 12, 0, false, LocalDate.of(2024, 6, 12), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1330, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(330, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(33, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay5dayCapitalFalse() {
        DepositCalculator DepositCalculator = new DepositCalculator(3333, 333, Deposit.DepositCalculator.termSelect.day, 12, 0, false, LocalDate.of(2024, 6, 13), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(3697.29, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(364.29, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(10.93, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay6dayCapitalFalse() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 1500, Deposit.DepositCalculator.termSelect.day, 12, 0, false, LocalDate.of(2024, 9, 22), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1492786880.65, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(492786880.65, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(49.28, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay7dayCapitalFalse() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 18000, Deposit.DepositCalculator.termSelect.day, 12, 0, false, LocalDate.of(2024, 9, 22), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(6913773131.16, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(5913773131.16, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(591.38, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay8dayCapitalFalse() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 1000, Deposit.DepositCalculator.termSelect.day, 12, 0, false, LocalDate.of(2024, 2, 29), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1328492249.38, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(328492249.38, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(32.85, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay9dayCapitalFalse() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 1000, Deposit.DepositCalculator.termSelect.day, 9.9, 0, false, LocalDate.of(2024, 12, 31), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1271232880, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(271232880, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(27.12, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay10dayCapitalFalse() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 1000, Deposit.DepositCalculator.termSelect.day, 0.1, 0, false, LocalDate.of(2024, 12, 31), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1002739730, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(2739730, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0.27, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeDay11dayCapitalFalse() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 18250, Deposit.DepositCalculator.termSelect.day, 12, 0, false, LocalDate.of(2024, 9, 22), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(6995964911.16, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(5995964911.16 , DepositCalculator.getInterestCharges());
        Assertions.assertEquals(599.6, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeDay12dayCapitalFalse() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 18250, Deposit.DepositCalculator.termSelect.day, 100, 0, false, LocalDate.of(2024, 9, 22), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(50966374777.22, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(49966374777.22 , DepositCalculator.getInterestCharges());
        Assertions.assertEquals(4996.64, DepositCalculator.getCapitalGains());
    }
}
