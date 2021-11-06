package controller;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import repository.impl.employee.DivisionImpl;
import repository.impl.employee.EducationDegreeImpl;
import repository.impl.employee.PositionImpl;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    public void init() {
        employeeService = new EmployeeServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insert(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
//                case "search":
//                    showSearchForm(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "update":
                    showUpdate(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                default:
                    showList(request, response);
                    break;
            }
        } catch (SQLException | IOException | ServletException ex) {
            ex.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> listEmployee = employeeService.selectAllEmployees();
        request.setAttribute("listEmployee", listEmployee);
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Division> divisions = DivisionImpl.selectAll();
        List<EducationDegree> educationDegrees = EducationDegreeImpl.selectAll();
        List<Position> positions = PositionImpl.selectAll();

        request.setAttribute("divisions", divisions);
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("positions", positions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    //
    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        List<Division> divisions = DivisionImpl.selectAll();
        List<EducationDegree> educationDegrees = EducationDegreeImpl.selectAll();
        List<Position> positions = PositionImpl.selectAll();

        request.setAttribute("employee", employee);
        request.setAttribute("divisions", divisions);
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("positions", positions);

        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birthDay = request.getParameter("birthDay");
        String idCard = request.getParameter("idCard");
        Double salary = Double.valueOf((request.getParameter("salary")));
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        int idDivision = Integer.parseInt(request.getParameter("division_type"));
        Division division = new Division(idDivision);

        int idEducationDegree = Integer.parseInt(request.getParameter("education_degrees_type"));
        EducationDegree educationDegree = new EducationDegree(idEducationDegree);

        int idPosition = Integer.parseInt(request.getParameter("position_type"));
        Position position = new Position(idPosition);
        Employee employee = new Employee(id, name, birthDay, idCard, salary, phone, email,address,
                position, educationDegree, division);
        employeeService.update(employee);
        showList(request, response);
    }


    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birthDay = request.getParameter("birthDay");
        String idCard = request.getParameter("idCard");
        Double salary = Double.valueOf((request.getParameter("salary")));
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        int idDivision = Integer.parseInt(request.getParameter("division_type"));
        Division division = new Division(idDivision);

        int idEducationDegree = Integer.parseInt(request.getParameter("education_degree_type"));
        EducationDegree educationDegree = new EducationDegree(idEducationDegree);

        int idPosition = Integer.parseInt(request.getParameter("position_type"));
        Position position = new Position(idPosition);

        Employee employee = new Employee(id, name, birthDay, idCard, salary, phone, email,address,
                position, educationDegree, division);

        employeeService.insert(employee);

        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        request.setAttribute("message", "New employee was created");
        dispatcher.forward(request, response);
    }
//
//    private void updateUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//
//        User book = new User(id, name, email, country);
//        userService.updateUser(book);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
//        dispatcher.forward(request, response);
//    }
//
    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        List<Employee> listEmployee = employeeService.selectAllEmployees();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");
        dispatcher.forward(request, response);
    }
//
//    private void showSearchForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        String country = request.getParameter("country");
//        String messenger = country + " is not found";
//        List<User> listSearchUser = userService.searchUser(country);
//        if(listSearchUser.isEmpty()){
//            request.setAttribute("messenger", messenger);
//        }
//        request.setAttribute("listSearchUser", listSearchUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/search.jsp");
//        dispatcher.forward(request, response);
//    }
}