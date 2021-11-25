package com.example.demo.service;

import com.example.demo.model.BorrowBook;
import com.example.demo.repository.BorrowBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowBookServiceImpl implements BorrowBookService{
    @Autowired
    BorrowBookRepository borrowBookRepository;

    @Override
    public void save(BorrowBook borrowBook) {
        borrowBookRepository.save(borrowBook);
    }

    @Override
    public Page<BorrowBook> findAll(Pageable pageable) {
        return borrowBookRepository.findAll(pageable);
    }

    @Override
    public Optional<BorrowBook> findById(int id) {
        return borrowBookRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        borrowBookRepository.deleteById(id);
    }


}
