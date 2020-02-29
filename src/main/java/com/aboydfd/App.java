package com.aboydfd;

public class App {
    public String getGreeting() {
        return "Hello boydfd.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
