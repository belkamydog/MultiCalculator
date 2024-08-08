package Deposit.DayPayments.Capitalisation;

import Deposit.DepositCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * Тесты для расчета депозита с ежедневными выплатами процентов
 * С капитализацией тип вводимой даты Deposit.DepositCalculator.termSelect.day
 * Эталонные значения расчитаны на депозитном калькуляторе с сайта "<a href="https://calcus.ru">calcus.ru</a>"
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */
public class TypeDayCapitalisationTest {
    /**
     * Tests - Payment type - Day - Capitalisation
     */
    @Test
    void typeDay1dayCapitalTrue() {
        DepositCalculator DepositCalculator = new DepositCalculator(1, 1, Deposit.DepositCalculator.termSelect.day, 12, 0, true, LocalDate.of(2024, 1, 1), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(0, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay2dayCapitalTrue() {
        DepositCalculator DepositCalculator = new DepositCalculator(1, 10, Deposit.DepositCalculator.termSelect.day, 12, 0, true, LocalDate.of(2024, 3, 12), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(0, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay3dayCapitalTrue() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000, 10, Deposit.DepositCalculator.termSelect.day, 12, 0, true, LocalDate.of(2024, 3, 12), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1003.3, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(3.3, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0.33, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay4dayCapitalTrue() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000, 1000, Deposit.DepositCalculator.termSelect.day, 12, 0, true, LocalDate.of(2024, 6, 12), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1388.87, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(388.87, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(38.89, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay5dayCapitalTrue() {
        DepositCalculator DepositCalculator = new DepositCalculator(3333, 333, Deposit.DepositCalculator.termSelect.day, 12, 0, true, LocalDate.of(2024, 6, 13), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(3717.88, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(384.88, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(11.55, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay6dayCapitalTrue() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 1500, Deposit.DepositCalculator.termSelect.day, 12, 0, true, LocalDate.of(2024, 9, 22), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1636739178.11, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(636739178.11, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(63.67, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay7dayCapitalTrue() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 18000, Deposit.DepositCalculator.termSelect.day, 12, 0, false, LocalDate.of(2024, 9, 22), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(6913773131.16, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(5913773131.16, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(591.38, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay8dayCapitalTrue() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 1000, Deposit.DepositCalculator.termSelect.day, 12, 0, false, LocalDate.of(2024, 2, 29), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1328492249.38, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(328492249.38, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(32.85, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay9dayCapitalTrue() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 1000, Deposit.DepositCalculator.termSelect.day, 9.9, 0, true, LocalDate.of(2024, 12, 31), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1311532236.25, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(311532236.25, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(31.15, DepositCalculator.getCapitalGains());
    }

    @Test
    void typeDay10dayCapitalTrue() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 1000, Deposit.DepositCalculator.termSelect.day, 0.1, 0, true, LocalDate.of(2024, 12, 31), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(1002743478.71, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(2743478.71, DepositCalculator.getInterestCharges());
        Assertions.assertEquals(0.27, DepositCalculator.getCapitalGains());
    }
    @Test
    void typeDay11dayCapitalTrue() {
        DepositCalculator DepositCalculator = new DepositCalculator(1000000000, 18250, Deposit.DepositCalculator.termSelect.day, 12, 0, true, LocalDate.of(2024, 9, 22), Deposit.DepositCalculator.termSelect.day);
        DepositCalculator.calculate();
        Assertions.assertEquals(401408738652.99, DepositCalculator.getResultDepositAmount());
        Assertions.assertEquals(400408738652.99 , DepositCalculator.getInterestCharges());
        Assertions.assertEquals(40040.87, DepositCalculator.getCapitalGains());
    }
}
