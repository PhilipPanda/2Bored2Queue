package com.twobored2queue.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import com.twobored2queue.discord.commands.*;

public class CommandManager extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String content = event.getMessage().getContentRaw().trim().toLowerCase();

        switch (content) {
            case "!status" -> new StatusCommand().execute(event);
            case "!shutdown" -> new ShutdownCommand().execute(event);
            case "!queue" -> new QueueCommand().execute(event);
            case "!connect" -> new ConnectCommand().execute(event);
            default -> {
                if (content.startsWith("!")) {
                    event.getChannel().sendMessage("❓ Unknown command. Try `!status`, `!queue`, `!connect`, `!shutdown`.").queue();
                }
            }
        }
    }
}
