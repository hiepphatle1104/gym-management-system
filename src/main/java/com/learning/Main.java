package com.learning;

import com.learning.models.Member;
import com.learning.service.AuthService;
import com.learning.service.MemberService;

import java.io.*;
import java.util.Scanner;

public class Main {
    static AuthService authService = new AuthService();

    static void showMenu(Scanner sc) {
        while(true) {
            IO.println("1. Login");
            IO.println("2. Exit");

            IO.print("Enter your choice: ");
            int opts = Integer.parseInt(sc.nextLine());

            if (opts == 2) break;

            IO.print("Enter your username: ");
            String username = sc.nextLine();

            IO.print("Enter your password: ");
            String password = sc.nextLine();

//            authService.login(username, password);
        }
    }

    static void main() {
        MemberService memberService = new MemberService();
        Member member = new Member("hphat", "123");

        memberService.loadFile();
        memberService.save(member);
        memberService.getMembers();
    }
}
