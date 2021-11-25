package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.BorrowBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BorrowBookService {
    void save(BorrowBook borrowBook);

    Page<BorrowBook> findAll(Pageable pageable);

    Optional<BorrowBook> findById(int id);


    void remove(int id);
}
