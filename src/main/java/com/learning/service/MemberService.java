package com.learning.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.learning.models.Member;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemberService {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String fileDirectory = "data/members.json";
    private static List<Member> members = new ArrayList<>();
    private static final Type listType = new TypeToken<List<Member>>(){}.getType();

    public void loadFile() {
        try (Reader reader = new FileReader(fileDirectory)) {
            members = gson.fromJson(reader, listType);
        } catch (IOException e) {
            IO.println("Error while listing members: " + e.getMessage());
        }
    }

    public void getMembers() {
        for (Member member : members)
            IO.println(member.toString());
    }

    public void save(Member member) {
        try (Writer writer = new FileWriter(fileDirectory)) {
            if (members.contains(member))
                return;

        } catch (IOException e) {
            IO.println("Error while saving member: " + e.getMessage());
        }
    }
}
