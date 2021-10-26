package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", value ="/index")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double price  = Double.parseDouble(request.getParameter("txtPrice"));
        double dis = Double.parseDouble(request.getParameter("txtDiscount"));
        double result = price * dis * 0.01;
        double total = price - result;

        request.setAttribute("resultFromServlet",result);
        request.setAttribute("resultFromServlet1",total);
        request.getRequestDispatcher("final.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
