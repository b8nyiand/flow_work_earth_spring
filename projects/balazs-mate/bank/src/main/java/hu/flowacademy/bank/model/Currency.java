package hu.flowacademy.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum Currency {
    HUF("HUF"),
    EUR("EUR"),
    AUD("AUD"),
    CHF("CHF"),
    GBP("GBP"),
    PLN("PLN"),
    RON("RON"),
    USD("USD");

    private String name;

}
