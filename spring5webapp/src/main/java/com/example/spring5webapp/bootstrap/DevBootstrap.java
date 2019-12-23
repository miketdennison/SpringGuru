package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.model.Author;
import com.example.spring5webapp.model.Book;
import com.example.spring5webapp.model.Publisher;
import com.example.spring5webapp.repositories.AuthorRepository;
import com.example.spring5webapp.repositories.BookRepository;
import com.example.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Publisher publisher = new Publisher();
        publisher.setName("SomeSoftware");
        publisherRepository.save(publisher);

        // Michael
        Author michael = new Author("Michael", "Dennison");
        Book dsb = new Book("Dark Souls Bro", "1234", publisher);
        michael.getBooks().add(dsb);
        dsb.getAuthors().add(michael);

        authorRepository.save(michael);
        bookRepository.save(dsb);

        // Alyssa
        Author alyssa = new Author("Alyssa", "Dennison");
        Book cd = new Book("Charlie Dude", "5678", publisher);
        alyssa.getBooks().add(cd);
        cd.getAuthors().add(alyssa);

        authorRepository.save(alyssa);
        bookRepository.save(cd);


    }
}
