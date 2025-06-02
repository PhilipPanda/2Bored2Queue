package com.twobored2queue.discord.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.Color;

public class QueueCommand {
    public void execute(MessageReceivedEvent event) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("📊 Queue Status")
                .setDescription("Queue position: ~42 (mock)")
                .setColor(Color.ORANGE);

        event.getChannel().sendMessageEmbeds(embed.build()).queue();
    }
}
