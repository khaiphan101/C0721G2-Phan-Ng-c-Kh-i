package repository.impl;

import model.employee.Employee;
import repository.ConnectionSQL;
import repository.EmployeeRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepoImpl implements EmployeeRepo {

    private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_EMPLOYEE_BY_COUNTRY = "select * from users where `country` like ?;";
    private static final String SELECT_ALL_EMPLOYEES = "select * from users";
    private static final String DELETE_EMPLOYEES_SQL = "delete from users where id = ?;";
    private static final String UPDATE_EMPLOYEES_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public EmployeeRepoImpl() {
    }

    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEES_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = new ConnectionSQL().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL)) {
            ((PreparedStatement) preparedStatement).setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
    }

    public Employee selectEmployee(int id) {
        Employee user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = new ConnectionSQL().getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new Employee(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
        return user;
    }

    public List<Employee> selectAllEmployees() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Employee> employees = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = new ConnectionSQL().getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                employees.add(new Employee(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
        return employees;
    }

    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEES_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }finally {
            ConnectionSQL.close();
        }
        return rowDeleted;
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEES_SQL);) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getCountry());
            statement.setInt(4, employee.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }finally {
            ConnectionSQL.close();
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public List<Employee> selectEmployeesByCountry(String country) {
        List<Employee> employees = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_COUNTRY);) {
            preparedStatement.setString(1, "%"+country+"%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Employee employee = new Employee(id, name, email, country);
                employees.add(employee);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
        return employees;
    }

    public List<Employee> searchEmployee(String country ) {
        List<Employee> employees = selectAllEmployees();
        List<Employee> listSearchByCountry = new ArrayList<>();
        for (Employee employee: employees) {
            if (employee.getName().toLowerCase().contains(country)){
                listSearchByCountry.add(employee);
            }
        }
        return listSearchByCountry;
    }

}
