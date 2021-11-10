//package service.impl;
//
//import repository.EmployeeRepo;
//import repository.impl.EmployeeRepoImpl;
//import service.EmployeeService;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class EmployeeServiceImpl implements EmployeeService {
//
//    private EmployeeRepo employeeRepo = new EmployeeRepoImpl();
//    @Override
//    public void insert(Employee employee) throws SQLException {
//        employeeRepo.insert(employee);
//    }
//
////    @Override
////    public Employee selectEmployee(int id) {
////        return employeeRepo.selectEmployee(id);
////    }
//
//    @Override
//    public List<Employee> selectAllEmployees() {
//        return employeeRepo.selectAllEmployees();
//    }
//
//    @Override
//    public boolean deleteEmployee(int id) throws SQLException {
//        return employeeRepo.deleteEmployee(id);
//    }
//
//    @Override
//    public boolean update(Employee employee) throws SQLException {
//        return employeeRepo.update(employee);
//    }
//
//    @Override
//    public List<Employee> searchEmployee(String name, String id, String email) throws SQLException {
//        return employeeRepo.searchEmployee(name, id, email);
//    }
//    public Employee findById(int id){
//        return employeeRepo.findById(id);
//    }
//}
