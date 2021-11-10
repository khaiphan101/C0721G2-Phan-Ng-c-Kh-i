package repository;

import model.Book;
import model.Card;

import java.sql.SQLException;
import java.util.List;

public interface BookRepo {
    public List<Book> selectAll();
    public boolean delete(String id) throws SQLException;
    public void create(Card card) throws SQLException;
    public Book findById(String id);
    public boolean update(Book book) throws SQLException;
    public List<Book> search(String name, String id, String email) throws SQLException;
}
