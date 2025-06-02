package com.twobored2queue.discord.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ConnectCommand {
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("🔌 The alt is still waiting in queue. You'll be notified when ready.").queue();
    }
}
