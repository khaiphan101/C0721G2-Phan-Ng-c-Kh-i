package controller;

import model.Book;
import model.Card;
import model.Status;
import model.Student;
import repository.impl.book.StudentImpl;
import service.BookService;
import service.impl.BookServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PremiseServlet", urlPatterns = {"/book"})
public class BookServlet extends HttpServlet {
    private BookService bookService;

    public void init() {
        bookService = new BookServiceImpl();
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
//                    create(request, response);
                    break;
                case "update":
//                    update(request, response);
                    break;
                case "search":
//                    showSearchForm(request, response);
                case "borrow":
                    borrow(request, response);
                    break;
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
//                    showNewForm(request, response);
                    break;
                case "update":
//                    showUpdate(request, response);
                    break;
                case "delete":
//                    delete(request, response);
                    break;
                case "borrow":
                    showBorrow(request, response);
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
        List<Book> bookList = bookService.selectAll();
        request.setAttribute("list", bookList);
        request.getRequestDispatcher("book/list.jsp").forward(request, response);
    }

    private void showBorrow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (request.getParameter("id"));
        Book book = bookService.findById(id);
        request.setAttribute("book", book);

        List<Student> studentList = StudentImpl.selectAll();
        request.setAttribute("studentList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/borrow.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void borrow(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String idBorrowBook = request.getParameter("idBorrowBook");

        String studentName = request.getParameter("studentName");
        String borrowDay = request.getParameter("borrowDay");
        String returnDay = request.getParameter("returnDay");

        String idStatus = (request.getParameter("status"));
        Status status = new Status(idStatus);

        String idStudent = (request.getParameter("premiseType"));
        Student student = new Student(idStudent);

        String bookName = (request.getParameter("bookName"));
        Book book = new Book(bookName);

        Card card = new Card(idBorrowBook,book, student, status, borrowDay, returnDay);


            bookService.create(card);
            RequestDispatcher dispatcher = request.getRequestDispatcher("book/create.jsp");
            request.setAttribute("message", "New card was created");
            dispatcher.forward(request, response);

    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        List<Status> statusList = StatusImpl.selectAll();
//        List<PremiseType> premiseTypeList = PremiseTypeImpl.selectAll();
//
//        request.setAttribute("statusList", statusList);
//        request.setAttribute("premiseTypeList", premiseTypeList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("premise/create.jsp");
//        dispatcher.forward(request, response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
//        String id = (request.getParameter("id"));
//        Premise premise = premiseService.findById(id);
//        List<Status> statusList = StatusImpl.selectAll();
//        List<PremiseType> premiseTypeList = PremiseTypeImpl.selectAll();
//
//        request.setAttribute("premise", premise);
//        request.setAttribute("statusList", statusList);
//        request.setAttribute("premiseTypeList", premiseTypeList);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("premise/update.jsp");
//
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }
//
    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        String id = (request.getParameter("id"));
//        double area = Double.parseDouble(request.getParameter("area"));
//        int floor = Integer.parseInt(request.getParameter("floor"));
//        int price = Integer.parseInt(request.getParameter("price"));
//        String startDay = request.getParameter("startDay");
//        String endDay = request.getParameter("endDay");
//
//        int idStatus = Integer.parseInt(request.getParameter("status"));
//        Status status = new Status(idStatus);
//
//        int idPremiseType = Integer.parseInt(request.getParameter("premiseType"));
//        PremiseType premiseType = new PremiseType(idPremiseType);
//
//        Premise premise = new Premise(id,status, area, floor, premiseType, price, startDay, endDay);
//        premiseService.update(premise);
//        showList(request, response);
    }
//
//
    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        Boolean flag = false;
//        String idError = "";
//        String phoneError = "";
//        String emailError = "";
//        String birthDayError = "";
//        String idCardError = "";
//        String salaryError = "";
//
//        String id = request.getParameter("id");
//
//        double area = Double.parseDouble(request.getParameter("area"));
//        int floor = Integer.parseInt(request.getParameter("floor"));
////        if(Validate.checkRegex(email,Validate.EMAIL_REGEX)) {
////            flag = true;
////            emailError = "Wrong format, ex: hainam123@gmail.com";
////        }
//        int price = Integer.parseInt(request.getParameter("price"));
////        if(Validate.checkRegex(birthDay,Validate.DATE_REGEX)) {
////            flag = true;
////            birthDayError = "Wrong format, ex: YYYY-MM-DD";
////        }
//        String startDay = request.getParameter("startDay");
////        if(Validate.checkRegex(idCard,Validate.ID_CARD_REGEX)){
////            flag=true;
////            idCardError ="Wrong format, ex: XXXXXXXXX or XXXXXXXXXXXX";
////        }
//        String endDay = (request.getParameter("endDay"));
////        if(salary<=0) {
////            flag = true;
////            salaryError = "please enter a positive number";
////        }
//
//        int idStatus = Integer.parseInt(request.getParameter("status"));
//        Status status = new Status(idStatus);
//
//        int idPremiseType = Integer.parseInt(request.getParameter("premiseType"));
//        PremiseType premiseType = new PremiseType(idPremiseType);
//
//        Premise premise = new Premise(id,status, area, floor, premiseType, price, startDay, endDay);
//
////        if(flag) {
////            request.setAttribute("phoneError", phoneError);
////            request.setAttribute("emailError", emailError);
////            request.setAttribute("idError", idError);
////            request.setAttribute("birthDayError", birthDayError);
////            request.setAttribute("idCardError", idCardError);
////            request.setAttribute("salaryError", salaryError);
////            request.setAttribute("premise", premise);
////            showNewForm(request, response);
////
////        }
////
////        else{
//            premiseService.create(premise);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("premise/create.jsp");
//            request.setAttribute("message", "New premise was created");
//            dispatcher.forward(request, response);
////        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        String id = request.getParameter("id");
//        premiseService.delete(id);
//        List<Premise> listPremise = premiseService.selectAll();
//        request.setAttribute("list", listPremise);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("premise/list.jsp");
//        dispatcher.forward(request, response);
    }
    private void showSearchForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        String name = request.getParameter("findName");
//        String id = request.getParameter("findId");
//        String email = request.getParameter("findEmail");
//        String messenger = name + " is not found";
//        List<Premise> listSearch = premiseService.searchPremise(name, id, email);
//        if(listSearch.isEmpty()){
//            request.setAttribute("messenger", messenger);
//        }
//        request.setAttribute("listPremise", listSearch);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("premise/premise.jsp");
//        dispatcher.forward(request, response);
    }
}