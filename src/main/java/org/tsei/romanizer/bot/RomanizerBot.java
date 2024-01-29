package org.tsei.romanizer.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.tsei.romanizer.service.RomanizerService;

@Slf4j
@Component
public class RomanizerBot extends TelegramLongPollingBot {
    private static final String ROMANIZE_COMMAND = "/romanize";
    private final RomanizerService romanizerService;

    public RomanizerBot(@Autowired RomanizerService romanizerService,
                        @Value("${bot-token}") String botToken) {
        super(botToken);
        this.romanizerService = romanizerService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (messageText.startsWith(ROMANIZE_COMMAND)) {
                romanize(chat_id, messageText);
            } else if (messageText.startsWith("/help")) {
                try {
                    SendMessage message = new SendMessage();
                    message.setChatId(chat_id);
                    message.setText("/romanize Ти Мыекъуапэ къэлэ дах. Ар урам зэнкӀабзэхэмкӀэ зэтеутыгъэ.");
                    execute(message);
                } catch (Exception ignore) {}
            } else if (messageText.startsWith("/print-alphabet")) {
                try {
                    SendMessage message = new SendMessage();
                    message.setChatId(chat_id);
                    message.setText(romanizerService.getAlphabet());
                    execute(message);
                } catch (Exception ignore) {}
            } else {
                romanize(chat_id, messageText);
            }
        }
    }

    private void romanize(long chat_id, String messageText) {
        try {
            SendMessage message = new SendMessage();
            message.setChatId(chat_id);
            message.setText(romanizerService.romanize(messageText.replace(ROMANIZE_COMMAND, "")));
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Could not romanize: " + messageText);
        }
    }

    @Override
    public String getBotUsername() {
        return "circassianromanizer_bot";
    }
}
