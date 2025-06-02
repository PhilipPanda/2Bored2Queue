package com.twobored2queue.discord.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.Color;

public class ConnectCommand {
    public void execute(MessageReceivedEvent event) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("🔌 Connection Status")
                .setDescription("The alt is still waiting in queue. You'll be notified when it's ready.")
                .setColor(Color.BLUE);

        event.getChannel().sendMessageEmbeds(embed.build()).queue();
    }
}
