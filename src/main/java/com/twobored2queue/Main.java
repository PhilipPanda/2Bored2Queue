package com.twobored2queue;

import com.google.gson.JsonObject;
import com.twobored2queue.config.ConfigLoader;
import com.twobored2queue.discord.DiscordBot;
import com.twobored2queue.server.LocalServer;

public class Main {
    public static void main(String[] args) {
        System.out.println("2Bored2Queue starting...");

        JsonObject config = ConfigLoader.load("config.json");

        String discordToken = config.get("discord_token").getAsString();
        DiscordBot.start(discordToken);

        int port = 25566;
        LocalServer server = new LocalServer(port);
        new Thread(server::start).start();

        System.out.println("[Server] Started local server on port " + port);
    }
}
