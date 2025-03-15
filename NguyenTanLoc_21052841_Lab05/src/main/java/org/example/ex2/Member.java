package org.example.ex2;

public class Member implements TaskObserver {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    @Override
    public void update(Task task) {
        System.out.println("Member " + name + " notified. Task '" + task.getStatus() + "'");
    }
}