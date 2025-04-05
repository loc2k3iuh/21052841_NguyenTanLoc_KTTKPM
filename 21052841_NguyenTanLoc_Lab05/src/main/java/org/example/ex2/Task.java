package org.example.ex2;

import org.example.ex2.TaskObserver;

import java.util.ArrayList;
import java.util.List;

public class Task implements TaskSubject {
    private String name;
    private String status;
    private List<TaskObserver> observers = new ArrayList<>();

    public Task(String name) {
        this.name = name;
        this.status = "Not Started";
    }

    @Override
    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public String getStatus() {
        return status;
    }

    @Override
    public void notifyObservers() {
        for (TaskObserver observer : observers) {
            observer.update(this);
        }
    }
}
