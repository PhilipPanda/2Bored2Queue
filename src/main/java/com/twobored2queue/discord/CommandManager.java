package com.twobored2queue.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import com.twobored2queue.discord.commands.StatusCommand;

public class CommandManager extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String content = event.getMessage().getContentRaw();

        if (content.equalsIgnoreCase("!status")) {
            new StatusCommand().execute(event);
        }
    }
}