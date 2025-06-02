package com.twobored2queue.discord;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.EnumSet;

public class DiscordBot {

    public static void start(String token) {
        try {
            JDABuilder.createDefault(token)
                    .enableIntents(EnumSet.of(
                            GatewayIntent.GUILD_MESSAGES,
                            GatewayIntent.MESSAGE_CONTENT
                    ))
                    .setActivity(Activity.playing("Waiting in queue..."))
                    .addEventListeners(new CommandManager())
                    .build();

            System.out.println("[Discord] Bot started successfully.");
        } catch (Exception e) {
            System.err.println("[Discord] Failed to start bot: " + e.getMessage());
        }
    }
}
