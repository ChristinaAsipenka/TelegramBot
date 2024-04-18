package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "CA_85_javs_bot";
    public static final String TOKEN = "6551479315:AAG6R_GECNMBAOulelpnUUfwCNcHaAs_R7c";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Hack fridge", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                                 Map.of("steal a sausage","step_2_btn",
                                        "steal fish","step_2_btn",
                                        "throw off the jar","step_2_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Hack vacuum", "step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                                Map.of("Send for food","step_4_btn",
                                        "Ride a robot vacuum cleaner","step_4_btn",
                                        "Run away from the robot vacuum cleaner","step_4_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Switch on GoPro", "step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("run across the rooftops","step_6_btn",
                            "attack cats","step_6_btn",
                            "attack dogs","step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, Map.of("Hack Desktop", "step_7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("brag to the other cats","step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }

}
//if(getMessageText().equals("/start")) {
//sendTextMessageAsync("Hello, future JAVA-programmer *Christina*!");
//        }
//
//                if (getMessageText().equals("/bye")) {
//sendTextMessageAsync("Bye!");
//        }
//
//                if (getMessageText().contains("cat")) {
//sendTextMessageAsync("chose cat number: ", Map.of("cat 1", "cat1", "cat 2", "cat2"));
//        }
//
//        if (getCallbackQueryButtonKey().equals("cat1")) {
//sendPhotoMessageAsync("step_1_pic");
//        }
//
//                if (getCallbackQueryButtonKey().equals("cat2")) {
//sendPhotoMessageAsync("step_2_pic");
//        }
//
//                if (getMessageText().equals("smile")) {
//var message = getLastSentMessage();
//editTextMessageAsync(message.getMessageId(), message.getText() + " :) ");
//        }
