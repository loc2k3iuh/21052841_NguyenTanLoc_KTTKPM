package org.example;

import org.example.singleton.EagerInitializedSingleton;
import org.example.singleton.LazyInitializedSingleton;
import org.example.singleton.StaticBlockSingleton;
import org.example.singleton.ThreadSafeSingleton;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
            System.out.println(threadSafeSingleton.hashCode());
        });
        thread.start();
    }
}