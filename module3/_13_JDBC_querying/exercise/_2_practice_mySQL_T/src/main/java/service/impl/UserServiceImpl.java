package service.impl;

import bean.User;
import repository.IUserDAO;
import repository.impl.UserDAO;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{
    private IUserDAO iUserDAO = new UserDAO();
    @Override
    public void insertUser(User user) throws SQLException {
        iUserDAO.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return iUserDAO.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return iUserDAO.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return iUserDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return iUserDAO.updateUser(user);
    }

    @Override
    public List<User> searchUser(String country) throws SQLException {
        return iUserDAO.searchUser(country);
    }

    @Override
    public List<User> getAllUsers() {
        return iUserDAO.getAllUsers();
    }

    @Override
    public void editUser(User user) {
        iUserDAO.editUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        iUserDAO.deleteUserById(id);
    }

    @Override
    public String addUserTransaction() {
        return iUserDAO.addUserTransaction();
    }
}
