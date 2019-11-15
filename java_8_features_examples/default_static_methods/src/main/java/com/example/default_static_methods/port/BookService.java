package com.example.default_static_methods.port;

public interface BookService {
    static void getStatic() {
        System.out.println("I am static method from interface.");
    }

    default void getDefault() {
        System.out.println("I am default method from interface.");
    }
}
