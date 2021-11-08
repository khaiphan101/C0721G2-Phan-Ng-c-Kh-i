package repository.impl;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import repository.ConnectionSQL;
import repository.EmployeeRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepoImpl implements EmployeeRepo {

    private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employee (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_BY_ID = "select id,name,email,country from employee where id =?";
    private static final String SELECT_EMPLOYEE_BY_COUNTRY = "select * from employee where `country` like ?;";
    private static final String SELECT_ALL_EMPLOYEES = "select id_employee, full_name, email, birthday, e.id_position, name_position, e.id_education_degree, education_degree, e.id_division, name_division " +
            " from employee e join position d on e.id_position = d.id_position " +
            " join education_degree ed on ed.id_education_degree = e.id_education_degree " +
            " join division di on di.id_division = e.id_division;";
    private static final String DELETE_EMPLOYEES_SQL = "delete from employee where id = ?;";
    private static final String UPDATE_EMPLOYEES_SQL = "update employee set name = ?,email= ?, country =? where id = ?;";

    public EmployeeRepoImpl() {
    }

    public void insert(Employee employee) throws SQLException {
        try (Connection connection = new ConnectionSQL().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert employee values " +
                    " (?,?,?,?,?,?,?,?,?,?,?);")) {
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, employee.getPosition().getId());
            preparedStatement.setInt(4, employee.getEducationDegree().getId());
            preparedStatement.setInt(5, employee.getDivision().getId());
            preparedStatement.setString(6, employee.getBirthDay());
            preparedStatement.setString(7, employee.getIdCard());
            preparedStatement.setDouble(8, employee.getSalary());
            preparedStatement.setString(9, employee.getPhone());
            preparedStatement.setString(10, employee.getEmail());
            preparedStatement.setString(11, employee.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
    }

//    public Employee selectEmployee(int id) {
//        Employee employee = null;
//        // Step 1: Establishing a Connection
//        try (Connection connection = new ConnectionSQL().getConnection();
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
//            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
////                user = new Employee(id, name, email, country);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }finally {
//            ConnectionSQL.close();
//        }
//        return employee;
//    }

    public List<Employee> selectAllEmployees() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Employee> employees = new ArrayList<>();
        // Step 1: Establishing a Connection
        Connection connection = new ConnectionSQL().getConnection();
        try (

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select id_employee, full_name, email, birthday, id_card, salary, number, address,e.id_position," +
                             " name_position, ed.id_education_degree, education_degree,di.id_division, name_division " +
                     " from employee e join position d on e.id_position = d.id_position " +
                     " join education_degree ed on ed.id_education_degree = e.id_education_degree " +
                     " join division di on di.id_division = e.id_division;");) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id_employee");
                String name = rs.getString("full_name");
                String birthday = rs.getString("birthday");
                String id_card = rs.getString("id_card");
                Double salary = rs.getDouble("salary");
                String number = rs.getString("number");
                String email = rs.getString("email");
                String address = rs.getString("address");

                Position position = new Position();
                position.setId(rs.getInt("id_position"));
                 position.setName(rs.getString("name_position"));

                EducationDegree educationDegree = new EducationDegree();
                educationDegree.setId(rs.getInt("id_education_degree"));
                educationDegree.setName(rs.getString("education_degree"));

                Division division = new Division();
                division.setId(rs.getInt("id_division"));
                division.setName(rs.getString("name_division"));

                employees.add(new Employee(id, name, birthday, id_card, salary, number, email,address,
                        position, educationDegree, division));
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
             PreparedStatement statement = connection.prepareStatement(
                     " delete from employee where id_employee = ?;");) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }finally {
            ConnectionSQL.close();
        }
        return rowDeleted;
    }

    public boolean update(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "update employee set full_name = ?,email= ?, birthday=?, " +
                     "id_card=?,salary=?, number=?,address=?, id_position=?,id_education_degree=?,id_division=? where id_employee = ?;");) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getBirthDay());
            statement.setString(4, employee.getIdCard());
            statement.setDouble(5, employee.getSalary());
            statement.setString(6, employee.getPhone());
            statement.setString(7, employee.getAddress());
            statement.setInt(8, employee.getPosition().getId());
            statement.setInt(9, employee.getEducationDegree().getId());
            statement.setInt(10, employee.getDivision().getId());
            statement.setInt(11, employee.getId());

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

//    public List<Employee> selectEmployeesByCountry(String country) {
//        List<Employee> employees = new ArrayList<>();
////        // Step 1: Establishing a Connection
////        try (Connection connection = new ConnectionSQL().getConnection();
////             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_COUNTRY);) {
////            preparedStatement.setString(1, "%"+country+"%");
////            System.out.println(preparedStatement);
////            ResultSet rs = preparedStatement.executeQuery();
////            while (rs.next()) {
////                int id = rs.getInt("id");
////                String name = rs.getString("name");
////                String email = rs.getString("email");
////                Employee employee = new Employee(id, name, email, country);
////                employees.add(employee);
////            }
////        } catch (SQLException e) {
////            printSQLException(e);
////        }finally {
////            ConnectionSQL.close();
////        }
//        return employees;
//    }

    public List<Employee> searchEmployee(String nameInput, String idInput, String emailInput ) {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select id_employee, full_name, email, birthday, id_card, salary, number, \n" +
                     " address,e.id_position,name_position, ed.id_education_degree, education_degree,di.id_division, \n" +
                     " name_division from employee e join position d on e.id_position = d.id_position \n" +
                     " join education_degree ed on ed.id_education_degree = e.id_education_degree\n" +
                     " join division di on di.id_division = e.id_division\n" +
                     " where `full_name` like concat('%',?,'%') and id_employee = ? \n" +
                     " and email like concat('%',?,'%');")) {
            preparedStatement.setString(1, nameInput);
            preparedStatement.setString(2, idInput);
            preparedStatement.setString(3, emailInput);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_employee");
                String name = rs.getString("full_name");
                String birthday = rs.getString("birthday");
                String id_card = rs.getString("id_card");
                Double salary = rs.getDouble("salary");
                String number = rs.getString("number");
                String email = rs.getString("email");
                String address = rs.getString("address");

                Position position = new Position();
                position.setId(rs.getInt("id_position"));
                position.setName(rs.getString("name_position"));

                EducationDegree educationDegree = new EducationDegree();
                educationDegree.setId(rs.getInt("id_education_degree"));
                educationDegree.setName(rs.getString("education_degree"));

                Division division = new Division();
                division.setId(rs.getInt("id_division"));
                division.setName(rs.getString("name_division"));

                employees.add(new Employee(id, name, birthday, id_card, salary, number, email,address,
                        position, educationDegree, division));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
        return employees;
    }

    public Employee findById(int id) {
        List<Employee> employees = selectAllEmployees();
        Employee employee = null;
        for (Employee temp : employees){
            if(temp.getId() == id) {
                employee = temp;
            }
        }
        return employee;
    }
}
