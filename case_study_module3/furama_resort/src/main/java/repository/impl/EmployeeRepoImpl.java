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

    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEES_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = new ConnectionSQL().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL)) {
            ((PreparedStatement) preparedStatement).setString(1, employee.getName());
//            preparedStatement.setString(2, employee.getEmail());
//            preparedStatement.setString(3, employee.getCountry());
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
                     "select id_employee, full_name, email, birthday, id_card, salary, number, address, name_position,  education_degree,  name_division " +
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
                String email = rs.getString("email");
                String birthday = rs.getString("birthday");
                Double id_card = rs.getDouble("id_card");
                String salary = rs.getString("salary");
                String number = rs.getString("number");
                String address = rs.getString("address");

                Position position = new Position();
                 position.setName(rs.getString("name_position"));

                EducationDegree educationDegree = new EducationDegree();
                educationDegree.setName(rs.getString("education_degree"));

                Division division = new Division();
                division.setName(rs.getString("name_division"));

                employees.add(new Employee(id, name, email, birthday, id_card, salary, number,address,
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
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEES_SQL);) {
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
                     "update employee set name = ?,email= ?, birthday=?, " +
                     "id_card=?,salary=?, number=?,address=?, position=?,educationDegree=?,division=? where id = ?;");) {
//            Employee employee = new Employee(id, name, email, birthday, id_card, salary, number,address,
//                    position, educationDegree, division);
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

    public List<Employee> searchEmployee(String country ) {
//        List<Employee> employees = selectAllEmployees();
        List<Employee> listSearchByCountry = new ArrayList<>();
//        for (Employee employee: employees) {
//            if (employee.getName().toLowerCase().contains(country)){
//                listSearchByCountry.add(employee);
//            }
//        }
        return listSearchByCountry;
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
