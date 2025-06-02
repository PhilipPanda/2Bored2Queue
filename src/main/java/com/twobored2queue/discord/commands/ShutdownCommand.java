package com.twobored2queue.discord.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ShutdownCommand {
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("🛑 Shutting down...").queue();
        System.exit(0);
    }
}
