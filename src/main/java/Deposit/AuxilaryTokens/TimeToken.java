package Deposit.AuxilaryTokens;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Содержит в себе данные за определенный временной промежуток (month/day/year)
 * */
@Getter
@Setter
public class TimeToken {
    private LocalDate date;
    private double interests;
    private double balance;
    private double changeBalance;
    private boolean status;

    public TimeToken(LocalDate date, double interests, double balance){
        this.date = date;
        this.interests = interests;
        this.balance = balance;
    }
}
