package Deposit.DepositCalculator;

import Deposit.AuxilaryTokens.BalanceAction;
import Deposit.AuxilaryTokens.TimeToken;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

@Getter
@Setter
public class DepositCalculator {
    public enum termSelect {
        day,
        month,
        year
    }

    /**
     * Input data fields
     **/
    private long startAmount;
    private int placementPeriod;
    private String periodType;
    private double interestRate;
    private double taxRate;
    private boolean capitalisation;
    private LocalDate startDate;
    private ArrayList<BalanceAction> pushMoney;
    private ArrayList<BalanceAction> popMoney;
    private String paymentType;

    /**
     * Calculate fields
     **/
    private BigDecimal interestCharges;
    private BigDecimal resultDepositAmount;
    private BigDecimal tax;
    private double capitalGains;
    private ArrayList<TimeToken> statistic;

    /**
     * Конструктор без пополнений и снятий в период депозита
     *
     * @param startAmount     - сумма вклада
     * @param placementPeriod - срок депозита
     * @param periodType      - тип срока (day, month, year)
     * @param interestRate    - годовая процентная ставка
     * @param taxRate         - годовая налоговая ставка
     * @param capitalisation  - наличие капитализации
     */
    public DepositCalculator(long startAmount, int placementPeriod, String periodType, double interestRate, double taxRate, boolean capitalisation, LocalDate startDate, String paymentType) {
        this.startAmount = startAmount;
        this.placementPeriod = placementPeriod;
        this.periodType = periodType;
        this.interestRate = interestRate;
        this.taxRate = taxRate;
        this.capitalisation = capitalisation;
        this.startDate = startDate;
        this.paymentType = paymentType;
        statistic = new ArrayList<>();
        pushMoney = new ArrayList<>();
        popMoney = new ArrayList<>();
        resultDepositAmount = BigDecimal.ZERO;
        interestCharges = BigDecimal.ZERO;
        tax = BigDecimal.ZERO;
        getDebitDaysCount();
    }

    /**
     * Конструктор с массивом пополнений и снятий в период депозита
     *
     * @param startAmount     - сумма вклада
     * @param placementPeriod - срок депозита
     * @param periodType      - тип срока (day, month, year)
     * @param interestRate    - годовая процентная ставка
     * @param taxRate         - годовая налоговая ставка
     * @param capitalisation  - наличие капитализации
     * @param popMoney        - массив пополнений и досрочных снятий
     * @param pushMoney       - массив пополнений и досрочных снятий
     */
    public DepositCalculator(long startAmount, int placementPeriod, String periodType, double interestRate, double taxRate, boolean capitalisation, LocalDate startDate, ArrayList<BalanceAction> pushMoney, ArrayList<BalanceAction> popMoney, String paymentType) {
        this.startAmount = startAmount;
        this.placementPeriod = placementPeriod;
        this.periodType = periodType;
        this.interestRate = interestRate;
        this.taxRate = taxRate;
        this.capitalisation = capitalisation;
        this.startDate = startDate;
        this.pushMoney = pushMoney;
        this.popMoney = popMoney;
        this.paymentType = paymentType;
        statistic = new ArrayList<>();
        resultDepositAmount = BigDecimal.ZERO;
        interestCharges = BigDecimal.ZERO;
        tax = BigDecimal.ZERO;
        getDebitDaysCount();
    }

    public double getResultDepositAmount() {
        return resultDepositAmount.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public double getInterestCharges() {
        return interestCharges.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public double getTax() {
        return tax.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public void calculate() {
        if (paymentType.equals(termSelect.day.name())) dayPayments();
        else if (paymentType.equals(termSelect.month.name())) monthPayments();
        else if (paymentType.equals(termSelect.year.name())) yearPayments();
    }

    public void dayPayments() {
        LocalDate currentDate = startDate.plusDays(1);
        resultDepositAmount = BigDecimal.valueOf(startAmount);
        LocalDate endDate = startDate.plusDays(placementPeriod);
        while (currentDate.isBefore(endDate)) {
            BigDecimal day_interests = calcDayInterests(currentDate.lengthOfYear()).setScale(2, RoundingMode.HALF_EVEN);
            interestCharges = interestCharges.add(day_interests);
            TimeToken day = new TimeToken(currentDate, day_interests.doubleValue(), resultDepositAmount.setScale(2, RoundingMode.HALF_EVEN).doubleValue());
            if (capitalisation) {
                day.setChangeBalance(day_interests.doubleValue());
                day.setBalance(day_interests.add(resultDepositAmount).doubleValue());
            }
            statistic.add(day);
            if (capitalisation) resultDepositAmount = resultDepositAmount.add(day_interests.setScale(2, RoundingMode.HALF_EVEN));
            currentDate = currentDate.plusDays(1);
        }
        preparedResults();
    }

    public void monthPayments() {
        LocalDate currentDate = startDate.plusDays(1);
        resultDepositAmount = BigDecimal.valueOf(startAmount);
        LocalDate endDate = startDate.plusDays(placementPeriod);
        LocalDate next_month = startDate.plusMonths(1);
        BigDecimal month_interests = BigDecimal.ZERO;
        while (currentDate.isBefore(endDate)) {
            month_interests = month_interests.add(calcDayInterests(currentDate.lengthOfYear()));
            if (currentDate.equals(next_month) || currentDate.equals(endDate.minusDays(1))) {
                double interest = month_interests.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
                TimeToken month = new TimeToken(currentDate, interest,
                        resultDepositAmount.setScale(2, RoundingMode.HALF_EVEN).doubleValue());
                if (capitalisation){
                    month.setChangeBalance(interest);
                    month.setBalance(interest + resultDepositAmount.setScale(2, RoundingMode.HALF_EVEN).doubleValue());
                }
                statistic.add(month);
                interestCharges = interestCharges.add(month_interests).setScale(2, RoundingMode.HALF_EVEN);
                if (capitalisation)
                    resultDepositAmount = resultDepositAmount.add(month_interests.setScale(2, RoundingMode.HALF_EVEN));
                month_interests = BigDecimal.ZERO;
                next_month = next_month.plusMonths(1);
            }
            currentDate = currentDate.plusDays(1);
        }
        preparedResults();
    }

    public void yearPayments() {
        LocalDate currentDate = startDate.plusDays(1);
        resultDepositAmount = BigDecimal.valueOf(startAmount);
        LocalDate endDate = startDate.plusDays(placementPeriod);
        LocalDate next_year = startDate.plusYears(1);
        if (startDate.getMonthValue() == 2 && startDate.getDayOfMonth() == 29) {
            next_year = next_year.plusDays(1);
            if (endDate.minusYears(1).lengthOfYear() == 366) endDate = endDate.plusDays(1);
        }
        BigDecimal year_interests = BigDecimal.ZERO;
        while (currentDate.isBefore(endDate)) {
            year_interests = year_interests.add(calcDayInterests(currentDate.lengthOfYear()));
            if (currentDate.equals(next_year) || currentDate.equals(endDate.minusDays(1))) {
                double interest = year_interests.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
                TimeToken year = new TimeToken(currentDate, interest, resultDepositAmount.setScale(2, RoundingMode.HALF_EVEN).doubleValue());
                if (capitalisation){
                    year.setChangeBalance(interest);
                    year.setBalance(interest+resultDepositAmount.setScale(2, RoundingMode.HALF_EVEN).doubleValue());
                }
                statistic.add(year);
                interestCharges = interestCharges.add(year_interests).setScale(2, RoundingMode.HALF_EVEN);
                if (capitalisation)
                    resultDepositAmount = resultDepositAmount.add(year_interests.setScale(2, RoundingMode.HALF_EVEN));
                year_interests = BigDecimal.ZERO;
                next_year = next_year.plusYears(1);
            }
            currentDate = currentDate.plusDays(1);
        }
        preparedResults();
    }

    protected void preparedResults() {
        if (!capitalisation) resultDepositAmount = resultDepositAmount.add(interestCharges);
        capitalGains = roundTwoSignAfterDot((double) (interestCharges.doubleValue() * 100) / startAmount);
    }

    public void getDebitDaysCount() {
        int days_count = 0;
        LocalDate end_date;
        if (periodType.equals(termSelect.year.name())) end_date = startDate.plusYears(placementPeriod);
        else if (periodType.equals(termSelect.month.name())) end_date = startDate.plusMonths(placementPeriod);
        else end_date = startDate.plusDays(placementPeriod);
        placementPeriod = (int) ChronoUnit.DAYS.between(startDate, end_date) + 1;
    }

    private double roundTwoSignAfterDot(double val) {
        val = Math.round(val * 100);
        return val / 100;
    }

    private @NotNull BigDecimal calcDayInterests(int countDaysInTheYear) {
        BigDecimal rate = new BigDecimal(interestRate);
        BigDecimal count_days = new BigDecimal(countDaysInTheYear);
        BigDecimal one_hundred = new BigDecimal(100);
        return rate.divide(count_days, MathContext.DECIMAL128).divide(one_hundred, MathContext.DECIMAL128).multiply(resultDepositAmount);
    }

    private void checkPushPopBalanceLists(LocalDate currentDate) {
        BigDecimal pushAndPopAmount = BigDecimal.ZERO;
        for (BalanceAction i : pushMoney) {
            if (i.getDate().equals(currentDate))
                pushAndPopAmount = pushAndPopAmount.add(BigDecimal.valueOf(i.getAmount()));

        }
        for (BalanceAction i : popMoney) {
            if (i.getDate().equals(currentDate)) {
                if (i.getAmount() <= resultDepositAmount.doubleValue())
                    pushAndPopAmount = pushAndPopAmount.subtract(BigDecimal.valueOf(i.getAmount()));
            }
        }
        resultDepositAmount = resultDepositAmount.add(pushAndPopAmount.setScale(2, RoundingMode.HALF_EVEN));
    }

    /**
     * Просмотр графика начисления процентов
     */
    public void printStat() {
        for (TimeToken i : statistic) {
            System.out.printf("%s\t%20s\t%20s\t%20s\n", i.getDate().toString(), Double.toString(i.getInterests()), Double.toString(i.getChangeBalance()),
                    Double.toString(i.getBalance()));
        }
    }
}
