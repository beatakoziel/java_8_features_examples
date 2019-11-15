package com.example.default_static_methods;

import com.example.default_static_methods.adapter.BookServiceImpl;
import com.example.default_static_methods.exception.BookNotFoundException;
import com.example.default_static_methods.model.Book;
import com.example.default_static_methods.model.Person;
import com.example.default_static_methods.port.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DefaultStaticMethodsApplication {

    public static void main(String[] args) {
        System.out.println("I am just checking how new features in Java 8 work.\n");
        List<Book> books = getListOfBooks();
        /*
        Optional.
        Is a container for object and can hold either object or null.
        We are able to check if object is present with simple isPresent() method.
        To get the object if it exists we call get() method on Optional.
        Optionals can help us with NullPointerException problem.
         */
        /*
        Streams.
        Are used to process data.
        We don't need to use loops to filter data.
        We are able to iterate over collection in just one simple line.
        We can easily validate elements with operations which return a boolean.
         */
        Optional<Book> foundedBook = books.stream()
                .filter(book -> book.getAuthor().getName().startsWith("R"))
                .findAny();
        if (!foundedBook.isPresent())
            throw new BookNotFoundException();
        System.out.println(String.format("I found a book %s!", foundedBook.get().getName()));

        /*
        Static method in interface.
        It cannot be overridden by implementing class.
        We are able to call this method without instance of the class.
         */
        BookService.getStatic();
        /*
        Default method in interface.
        We are able to add implementation of method to an interface after key word 'default'.
        It doesn't have to be overridden by implementing class, but can be.
        It is accessible by instance of the class.
         */
        BookService bookService = new BookServiceImpl();
        bookService.getDefault();
    }

    private static List<Book> getListOfBooks() {
        List<Book> books = new ArrayList<>();
        books.add(
                Book.builder()
                        .name("Clean Code")
                        .author(new Person("Robert", "Martin"))
                        .descrpition("Clean code is code that has been taken care of")
                        .build()
        );
        books.add(
                Book.builder()
                        .name("The Art of Computer Programming")
                        .author(new Person("Donald", "Knuth"))
                        .descrpition("This book is a true challenge of intellect and perseverance.")
                        .build()
        );
        return books;
    }

}
