package com.twobored2queue.config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.InputStream;
import java.io.InputStreamReader;

public class ConfigLoader {
    public static JsonObject load(String filename) {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(filename)) {
            if (input == null) throw new IllegalStateException(filename + " not found!");
            return new Gson().fromJson(new InputStreamReader(input), JsonObject.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load " + filename + ": " + e.getMessage(), e);
        }
    }
}