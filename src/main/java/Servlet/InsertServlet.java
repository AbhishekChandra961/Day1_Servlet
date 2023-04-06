package Servlet;

import Utility.RegexUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet.InsertServlet")
public class InsertServlet extends HttpServlet {
    public static String userName;
    public static String passWord;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RegexUtil regexUtil = new RegexUtil();
        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        if (regexUtil.isNameValid(username)) {

            if (regexUtil.isPasswordValid(password)) {

                InsertServlet.userName = username;
                InsertServlet.passWord = password;

                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("Success.jsp");
            } else {
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Insert.html");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Password - Rule1 – minimum 8 Characters - Rule2 – Should have at least 1 Upper\n" +
                        "Case\n" +
                        "- Rule3\n" +
                        "\n" +
                        "– Should have at least 1 numeric\n" +
                        "\n" +
                        "number in the password\n" +
                        "- Rule4\n" +
                        "\n" +
                        "– Has exactly 1 Special Character(EX : Abhi@123)</font>");
                requestDispatcher.include(request, response);
            }
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Insert.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>  Name should start with Cap and have minimum 3 characters (EX : Abhi)</font>");
            requestDispatcher.include(request, response);
        }
    }
}