package com.example.default_static_methods.model;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Book {
    private String name;
    private Person author;
    private String descrpition;
}
