package hu.flowacademy.bank.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankUserResponseDTO {

    private String username;
    private String fullname;
    private LocalDate creationDate;
    private String address;
    private Integer accounts;

}
