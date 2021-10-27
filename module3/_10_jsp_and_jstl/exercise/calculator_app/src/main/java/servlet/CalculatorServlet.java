package servlet;

import bean.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", value = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float a = Float.parseFloat(request.getParameter("firstO"));
        float b = Float.parseFloat(request.getParameter("secondO"));
        Calculator calculator = new Calculator(a,b);
        String operator = request.getParameter("operator");
        String result ="";
        switch (operator){
            case "add":
                result = calculator.add();
                break;
            case "sub":
                result = calculator.sub();
                break;
            case "mul":
                result = calculator.mul();
                break;
            case "div":
                result = calculator.div();
        }
        request.setAttribute("resultServlet", result);
        request.getRequestDispatcher("calculator.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
