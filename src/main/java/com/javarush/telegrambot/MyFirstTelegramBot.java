package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

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
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}