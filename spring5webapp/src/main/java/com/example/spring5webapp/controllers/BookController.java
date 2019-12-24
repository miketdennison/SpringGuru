package com.example.spring5webapp.controllers;

import com.example.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        // Add an attribute called books, which is a list of books from the repository
        model.addAttribute("books", bookRepository.findAll());

        // Returns to thymeleaf, associated with the book view
        return "books";
    }
}
