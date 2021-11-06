package service;

import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    public void insert(Employee employee) throws SQLException;

//    public Employee selectEmployee(int id);

    public List<Employee> selectAllEmployees();

    public boolean deleteEmployee(int id) throws SQLException;

    public boolean update(Employee employee) throws SQLException;

    public List<Employee> searchEmployee(String country) throws SQLException;

    public Employee findById(int id);
}
