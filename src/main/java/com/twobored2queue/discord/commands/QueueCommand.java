package com.twobored2queue.discord.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class QueueCommand {
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("📊 Queue position: ~42 (mock)").queue();
    }
}
