package com.chat.crons.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MailSchedulers {

//    @Scheduled(cron = "* * * * * *")
    public void sendMailsEveryday(){
        System.out.println("MAIL SENT");
    }
}
