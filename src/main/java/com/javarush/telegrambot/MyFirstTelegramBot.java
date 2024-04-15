package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "CA_85_javs_bot";
    public static final String TOKEN = "6551479315:AAG6R_GECNMBAOulelpnUUfwCNcHaAs_R7c";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {

        if(getMessageText().equals("/start")) {
            sendTextMessageAsync("Hello, future JAVA-programmer *Christina*!");
        }

        if (getMessageText().equals("/bye")) {
            sendTextMessageAsync("Bye!");
        }

        if (getMessageText().contains("cat")) {
            sendTextMessageAsync("chose cat number: ", Map.of("cat 1", "cat1", "cat 2", "cat2"));
        }

        if (getCallbackQueryButtonKey().equals("cat1")) {
            sendPhotoMessageAsync("step_1_pic");
        }

        if (getCallbackQueryButtonKey().equals("cat2")) {
            sendPhotoMessageAsync("step_2_pic");
        }

        if (getMessageText().equals("smile")) {
            var message = getLastSentMessage();
            editTextMessageAsync(message.getMessageId(), message.getText() + " :) ");
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}