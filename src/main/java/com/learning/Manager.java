package com.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Manager<T extends User> {
    protected final Scanner sc = new Scanner(System.in);
    protected final List<T> userList = new ArrayList<>();

    public List<T> getUserList() {
        return this.userList;
    }

    public abstract void addUser();

    public void listUser() {
        for (T user : this.userList)
            IO.println(user.toString());
    }

    public void deleteUser() {
        IO.print("Please enter username: ");
        String username = sc.nextLine();
        this.userList.removeIf(user -> user.getUsername().equals(username));
    }

    public abstract void updateUser();
}
