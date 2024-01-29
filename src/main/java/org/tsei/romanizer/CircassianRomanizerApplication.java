package org.tsei.romanizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class CircassianRomanizerApplication {

    public static void main(String[] args) throws TelegramApiException {
        ApplicationContext ctx = SpringApplication.run(CircassianRomanizerApplication.class, args);
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(ctx.getBean("romanizerBot", TelegramLongPollingBot.class));
    }

}
