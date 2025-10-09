package com.learning.service;

import java.util.Scanner;

public abstract class Service {
    protected static final Scanner sc = new Scanner(System.in);

    public abstract void showMenu();

    public abstract void save();

    public abstract void delete();

    public abstract void update();

    public abstract void list();

    public abstract void load();
}
