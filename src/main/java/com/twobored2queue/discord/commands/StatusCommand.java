package com.twobored2queue.discord.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class StatusCommand {
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("✅ Proxy is running. Waiting in queue...").queue();
    }
}