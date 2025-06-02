package com.twobored2queue.discord.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.Color;

public class StatusCommand {
    public void execute(MessageReceivedEvent event) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("✅ Proxy Status")
                .setDescription("The proxy is currently running and waiting in queue.")
                .setColor(Color.GREEN);

        event.getChannel().sendMessageEmbeds(embed.build()).queue();
    }
}
