package dev.patika.loanapplicationsystem.webSocketModel;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String text;
    private String result;

    public Message(String s) {
    }
}
