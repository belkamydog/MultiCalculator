package Deposit.AuxilaryTokens;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class BalanceAction {
    private LocalDate date;
    private long amount;
    private String type;
}
