package org.example.ex2;

public interface TaskSubject {
    public void addObserver(TaskObserver observer);
    public void removeObserver(TaskObserver observer);
    public void notifyObservers();
}
