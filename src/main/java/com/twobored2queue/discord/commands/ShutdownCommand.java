package com.twobored2queue.discord.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.Color;

public class ShutdownCommand {
    public void execute(MessageReceivedEvent event) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("🛑 Shutdown")
                .setDescription("The proxy is shutting down...")
                .setColor(Color.RED);

        event.getChannel().sendMessageEmbeds(embed.build()).queue();

        new Thread(() -> {
            try {
                Thread.sleep(1500); // wait 1.5 seconds
            } catch (InterruptedException ignored) {}
            System.exit(0);
        }).start();
    }
}
