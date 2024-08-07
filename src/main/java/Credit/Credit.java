package Credit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Credit {

    public enum creditPaymentType {
        annuity,
        differently
    }

    public enum creditTermType {
        month,
        year
    }

    private creditPaymentType paymentType;
    private BigDecimal loanAmount;
    private double interestRate;
    private Integer loanTerm;
    private creditTermType loanTermType;
    private LocalDate loanDate;

    private BigDecimal monthPayment;
    private BigDecimal minMonthPayment;
    private BigDecimal maxMonthPayment;
    private BigDecimal overpayment;
    private BigDecimal fullCost;
    List<MonthPayment> monthPayments;

    public Credit(creditPaymentType paymentType, Double loanAmount,
                  Double interestRate, Integer loanTerm, creditTermType loanTermType, LocalDate loanDate) {
        this.paymentType = paymentType;
        this.loanAmount = BigDecimal.valueOf(loanAmount);
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
        this.loanTermType = loanTermType;
        this.loanDate = loanDate;
        monthPayment = BigDecimal.ZERO;
        minMonthPayment = BigDecimal.ZERO;
        maxMonthPayment = BigDecimal.ZERO;
        overpayment = BigDecimal.ZERO;
        fullCost = BigDecimal.ZERO;
        monthPayments = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "{" +
                "paymentType: " + paymentType + ", " +
                "loanAmount: " + loanAmount + ", " +
                "interestRate: " + interestRate + ", " +
                "loanTerm: " + loanTerm + ", " +
                "loanTermType: " + loanTermType + ", " +
                "loanDate: " + loanDate + ", " +
                "monthPayment: " + monthPayment.setScale(2, RoundingMode.HALF_EVEN) + ", " +
                "minMonthPayment: " + minMonthPayment.setScale(2, RoundingMode.HALF_EVEN) + ", " +
                "maxMonthPayment: " + maxMonthPayment.setScale(2, RoundingMode.HALF_EVEN) + ", " +
                "overpayment: " + overpayment.setScale(2, RoundingMode.HALF_EVEN) + ", " +
                "fullCost: " + fullCost.setScale(2, RoundingMode.HALF_EVEN) + ", " +
                "monthPayments: " + monthPayments + "}";
    }

    public double getLoanAmount() {
        return loanAmount.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public double getMonthPayment() {
        return monthPayment.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public double getMinMonthPayment() {
        return minMonthPayment.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public double getMaxMonthPayment() {
        return maxMonthPayment.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public double getOverpayment() {
        return overpayment.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public double getFullCost() {
        return fullCost.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public void calculate() {
        termToMonth();
        if (paymentType == creditPaymentType.annuity) annuityCalculate();
        else diffCalculate();
    }

    private void termToMonth() {
        if (loanTermType == creditTermType.year) {
            loanTerm *= 12;
        }
    }

    private @NotNull String getDate(@NotNull LocalDate currentDate) {
        String month = currentDate.getMonth().toString();
        String year = String.valueOf(currentDate.getYear());
        return month + " " + year;
    }

    private void annuityCalculate() {
        BigDecimal monthRate = BigDecimal.valueOf(interestRate / (100 * 12));
        monthPayment = loanAmount.multiply(BigDecimal.valueOf(monthRate.doubleValue() / (1 - Math.pow((1 + monthRate.doubleValue()), -loanTerm))));
        overpayment = monthPayment.multiply(BigDecimal.valueOf(loanTerm)).subtract(loanAmount);
        fullCost = loanAmount.add(overpayment);
        LocalDate currentDate = loanDate;
        BigDecimal tmp = loanAmount;
        for (int i = 1; i <= loanTerm; i++) {
            String monthYear = getDate(currentDate);
            BigDecimal percent = monthRate.multiply(tmp).setScale(2, RoundingMode.HALF_EVEN);
            BigDecimal mainDebt = monthPayment.subtract(percent);
            tmp = tmp.subtract(mainDebt).setScale(2, RoundingMode.HALF_EVEN);
            MonthPayment current = new MonthPayment(i, monthYear, monthPayment.setScale(2, RoundingMode.HALF_EVEN).doubleValue(),
                    mainDebt.setScale(2, RoundingMode.HALF_EVEN).doubleValue(),
                    percent.setScale(2, RoundingMode.HALF_EVEN).doubleValue(),
                    tmp.setScale(2, RoundingMode.HALF_EVEN).doubleValue());
            monthPayments.add(current);
            currentDate = currentDate.plusMonths(1);
        }
        minMonthPayment = maxMonthPayment = monthPayment;
    }

    private void diffCalculate() {
        BigDecimal mainDebt = loanAmount.divide(BigDecimal.valueOf(loanTerm), 2, RoundingMode.HALF_EVEN);
        BigDecimal currentDebt = loanAmount;
        LocalDate currentDate = loanDate;
        ArrayList<Double> monthPaymentsForFindMaxMin = new ArrayList<>();
        for (int i = 1; i <= loanTerm; i++) {
            int dayMonth = YearMonth.of(currentDate.getYear(), currentDate.getMonth()).lengthOfMonth();
            int dayYear = Year.of(currentDate.getYear()).length();
            String monthYear = getDate(currentDate);
            BigDecimal accruedInterest = ((currentDebt.multiply(BigDecimal.valueOf(interestRate / 100)).multiply(BigDecimal.valueOf(dayMonth))).divide(BigDecimal.valueOf(dayYear), RoundingMode.HALF_EVEN));
            double mPay = mainDebt.add(accruedInterest).doubleValue();
            monthPaymentsForFindMaxMin.add(mPay);
            MonthPayment current = new MonthPayment(i, monthYear, mPay, mainDebt.doubleValue(), accruedInterest.doubleValue(), currentDebt.doubleValue());
            monthPayments.add(current);
            currentDebt = currentDebt.subtract(mainDebt);
            overpayment = overpayment.add(accruedInterest);
            currentDate = currentDate.plusMonths(1);
        }
        maxMonthPayment = BigDecimal.valueOf(Collections.max(monthPaymentsForFindMaxMin));
        minMonthPayment = BigDecimal.valueOf(Collections.min(monthPaymentsForFindMaxMin));
        fullCost = overpayment.add(loanAmount).setScale(2, RoundingMode.HALF_EVEN);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class MonthPayment {
        private int id;
        private String date;
        private double amount;
        private double mainDebt;
        private double accruedInterest;
        private double outstandingBalance;

        @Override
        public String toString() {
            return "{" +
                    "id: " + id + ", " +
                    "date: " + date + ", " +
                    "amount: " + amount + ", " +
                    "mainDebt: " + mainDebt + ", " +
                    "accruedInterest: " + accruedInterest + "}";
        }
    }
}
