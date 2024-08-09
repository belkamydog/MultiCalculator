package Deposit.AuxilaryTokens;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Содержит данные о пополнении снятии на {@link #date указанную дату}
 * */
@AllArgsConstructor
@Getter
@Setter
public class BalanceAction {
    private LocalDate date;
    private long amount;
    private String type;

    @Override
    public String toString() {
        return "BalanceAction{" +
                "date: " + date + ", " +
                "amount: " + amount + ", " +
                "type: " + type + "}";
    }
}
