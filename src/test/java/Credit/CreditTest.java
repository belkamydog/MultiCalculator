package Credit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * Тесты для расчета кредита
 * Эталонные значения расчитаны на депозитном калькуляторе с сайта "<a href="https://calcus.ru">calcus.ru</a>"
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */

public class CreditTest {

    @Test
    public void toStringMethodTest() {
        Credit credit = new Credit(Credit.creditPaymentType.annuity, 10000.0, 21.0, 1,
                Credit.creditTermType.year, LocalDate.of(2024, 1, 1));
        credit.calculate();
        Assertions.assertEquals(credit.toString(), "{paymentType: annuity, loanAmount: 10000.0, interestRate: 21.0, loanTerm: 12, loanTermType: year, loanDate: 2024-01-01, monthPayment: 931.14, minMonthPayment: 931.14, maxMonthPayment: 931.14, overpayment: 1173.65, fullCost: 11173.65, monthPayments: [{id: 1, date: JANUARY 2024, amount: 931.14, mainDebt: 756.14, accruedInterest: 175.0}, {id: 2, date: FEBRUARY 2024, amount: 931.14, mainDebt: 769.37, accruedInterest: 161.77}, {id: 3, date: MARCH 2024, amount: 931.14, mainDebt: 782.84, accruedInterest: 148.3}, {id: 4, date: APRIL 2024, amount: 931.14, mainDebt: 796.54, accruedInterest: 134.6}, {id: 5, date: MAY 2024, amount: 931.14, mainDebt: 810.48, accruedInterest: 120.66}, {id: 6, date: JUNE 2024, amount: 931.14, mainDebt: 824.66, accruedInterest: 106.48}, {id: 7, date: JULY 2024, amount: 931.14, mainDebt: 839.09, accruedInterest: 92.05}, {id: 8, date: AUGUST 2024, amount: 931.14, mainDebt: 853.77, accruedInterest: 77.37}, {id: 9, date: SEPTEMBER 2024, amount: 931.14, mainDebt: 868.72, accruedInterest: 62.42}, {id: 10, date: OCTOBER 2024, amount: 931.14, mainDebt: 883.92, accruedInterest: 47.22}, {id: 11, date: NOVEMBER 2024, amount: 931.14, mainDebt: 899.39, accruedInterest: 31.75}, {id: 12, date: DECEMBER 2024, amount: 931.14, mainDebt: 915.13, accruedInterest: 16.01}]}");
    }
    @Test
    public void annuityTest1() {
        Credit credit = new Credit(Credit.creditPaymentType.annuity, 10000.0, 21.0, 1,
                Credit.creditTermType.year, LocalDate.of(2024, 1, 1));
        credit.calculate();
        Assertions.assertEquals(931.14, credit.getMonthPayment());
        Assertions.assertEquals(1173.65, credit.getOverpayment());
        Assertions.assertEquals(11173.65, credit.getFullCost());
    }
    @Test
    public void diffTest1() {
        Credit credit = new Credit(Credit.creditPaymentType.differently, 10000.0, 21.0, 1,
                Credit.creditTermType.year, LocalDate.of(2024, 8, 7));
        credit.calculate();
        Assertions.assertEquals(848.19, credit.getMinMonthPayment());
        Assertions.assertEquals(1011.20, credit.getMaxMonthPayment());
        Assertions.assertEquals(1136.22, credit.getOverpayment());
        Assertions.assertEquals(11136.22, credit.getFullCost());
    }

}
