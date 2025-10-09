package com.learning.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.learning.domain.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class UserService<T extends User> extends Service {
    protected static final String fileName = "data/test.json";
    protected static List<User> users = new ArrayList<>();
    protected static final Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(User.class, new UserDeserializer()).create();
    private static final Type listType = new TypeToken<List<User>>() {
    }.getType();

    private User getUserByUsername(String username) {
        load();
        if (username == null) return null;
        return users.stream()
                .filter(u -> username.equals(u.getUsername()))
                .findFirst()
                .orElse(null);
    }

    public User authenticate(String username, String password) {
        User user = getUserByUsername(username);
        if (user == null) return null;

        boolean isValid = user.comparePassword(password);
        return isValid ? user : null;
    }

    @Override
    public void load() {
        try (Reader reader = new FileReader(fileName)) {
            users = gson.fromJson(reader, listType);
        } catch (Exception e) {
            IO.println("Error while loading data: " + e.getMessage());
        }
    }

    // Save all data
    public void persist() {
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(users, writer);
        } catch (Exception e) {
            IO.println("Error while persisting data: " + e.getMessage());
        }
    }
}
