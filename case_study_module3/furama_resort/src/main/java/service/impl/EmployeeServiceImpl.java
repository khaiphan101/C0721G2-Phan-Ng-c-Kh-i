package service.impl;

import model.employee.Employee;
import repository.EmployeeRepo;
import repository.impl.EmployeeRepoImpl;
import service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo = new EmployeeRepoImpl();
    @Override
    public void insertEmployee(Employee employee) throws SQLException {

    }

//    @Override
//    public Employee selectEmployee(int id) {
//        return employeeRepo.selectEmployee(id);
//    }

    @Override
    public List<Employee> selectAllEmployees() {
        return employeeRepo.selectAllEmployees();
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepo.deleteEmployee(id);
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        return employeeRepo.update(employee);
    }

    @Override
    public List<Employee> searchEmployee(String country) throws SQLException {
        return employeeRepo.searchEmployee(country);
    }
    public Employee findById(int id){
        return employeeRepo.findById(id);
    }
}
