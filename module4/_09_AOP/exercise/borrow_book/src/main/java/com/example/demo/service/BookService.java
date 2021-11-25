package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Optional<Book> findById(int id);

    void save(Book book);

    void addBorrowBook(Book book);
}
