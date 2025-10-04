package com.learning.service;

import com.learning.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberService extends Service {
    private final List<Member> members = new ArrayList<>();

    public void addMember() {
        IO.print("Please enter username: ");
        String username = sc.nextLine();
        Member member = new Member(username);

        members.add(member);
        IO.println("Added member: " + member.getUsername());
    }

    public List<Member> listMembers() {
        return new ArrayList<>(members);
    }

    public void deleteMember() {
        IO.print("Please enter username: ");
        String username = sc.nextLine();

        members.removeIf(m -> m.getUsername().equals(username));
        System.out.println("Deleted member: " + username);
    }

    public void updateMember() {
    }
}
