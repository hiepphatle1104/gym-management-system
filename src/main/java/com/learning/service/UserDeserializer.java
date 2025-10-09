package com.learning.service;

import com.google.gson.*;
import com.learning.domain.Admin;
import com.learning.domain.Member;
import com.learning.domain.Trainer;
import com.learning.domain.User;
import com.learning.domain.enums.UserRole;

import java.lang.reflect.Type;

public class UserDeserializer implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement json, Type type, JsonDeserializationContext ctx) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String role = jsonObject.get("role").getAsString();

        UserRole userRole;
        try {
            userRole = UserRole.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new JsonParseException("Unknown role: " + role);
        }

        return switch (userRole) {
            case UserRole.MEMBER -> ctx.deserialize(json, Member.class);
            case UserRole.ADMIN -> ctx.deserialize(json, Admin.class);
            case UserRole.TRAINER -> ctx.deserialize(json, Trainer.class);
        };
    }
}
