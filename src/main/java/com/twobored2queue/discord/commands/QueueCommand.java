package com.twobored2queue.discord.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QueueCommand {

    public void execute(MessageReceivedEvent event) {
        try {
            String apiUrl = "https://api.2b2t.vc/queue";
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);

            if (conn.getResponseCode() != 200) {
                event.getChannel().sendMessage("❌ Failed to fetch queue: " + conn.getResponseCode()).queue();
                return;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            in.close();
            conn.disconnect();

            event.getChannel().sendMessage("📊 Queue Status:\n```json\n" + response.toString() + "\n```").queue();

        } catch (Exception e) {
            event.getChannel().sendMessage("❌ Error fetching queue: " + e.getMessage()).queue();
        }
    }
}
