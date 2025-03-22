package org.example.singleton;

public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    EagerInitializedSingleton() {}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}
