package service.impl;

import model.Book;
import model.Card;
import repository.BookRepo;
import repository.impl.book.BookRepoImpl;
import service.BookService;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookRepo bookRepo = new BookRepoImpl();
    @Override
    public List<Book> selectAll() {
        return bookRepo.selectAll();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return bookRepo.delete(id);
    }

    @Override
    public void create(Card card) throws SQLException {
        bookRepo.create(card);
    }
        public Book findById(String id){
        return bookRepo.findById(id);
    }

    @Override
    public boolean update(Book book) throws SQLException {
        return bookRepo.update(book);
    }

    @Override
    public List<Book> search(String name, String id, String email) throws SQLException {
        return bookRepo.search(name,id,email);
    }


}
