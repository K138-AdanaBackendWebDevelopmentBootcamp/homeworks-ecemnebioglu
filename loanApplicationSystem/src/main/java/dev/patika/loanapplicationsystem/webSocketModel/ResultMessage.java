package dev.patika.loanapplicationsystem.webSocketModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultMessage {
    private Long idNumber;
    private double loanAmount;
    private String loanStatus;
}
