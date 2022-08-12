package dev.patika.loanapplicationsystem.controller;


import dev.patika.loanapplicationsystem.webSocketModel.Message;
import dev.patika.loanapplicationsystem.webSocketModel.ResultMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ResultMessageController {

    @MessageMapping("/resultmessage")
    @SendTo("/topic/results")
    public Message result(ResultMessage message){
        return new Message("Your loan application result is " +
                HtmlUtils.htmlEscape(message.getLoanStatus()) +
                "Your limit is " +
                HtmlUtils.htmlEscape(String.valueOf(message.getLoanAmount())));
    }
}
