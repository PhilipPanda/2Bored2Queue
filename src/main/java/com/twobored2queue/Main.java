package com.twobored2queue;

import com.google.gson.JsonObject;
import com.twobored2queue.config.ConfigLoader;
import com.twobored2queue.discord.DiscordBot;

public class Main {
    public static void main(String[] args) {
        System.out.println("2Bored2Queue starting...");

        JsonObject config = ConfigLoader.load("config.json");

        String discordToken = config.get("discord_token").getAsString();
        DiscordBot.start(discordToken);
    }
}