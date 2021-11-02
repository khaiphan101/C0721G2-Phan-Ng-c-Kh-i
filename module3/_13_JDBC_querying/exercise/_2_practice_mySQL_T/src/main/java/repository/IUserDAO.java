package repository;

import bean.User;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    public List<User> searchUser(String country) throws SQLException;

    public List<User> getAllUsers();
    public void editUser(User user);
    public void deleteUserById(int id);
    public String addUserTransaction();
}
