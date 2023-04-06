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

@WebServlet("/Servlet.LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String userName = request.getParameter("user");
        String password = request.getParameter("pass");

        if(userName.equals(InsertServlet.userName) && password.equals(InsertServlet.passWord)){

            HttpSession session = request.getSession();
            session.setAttribute("username",userName);
            response.sendRedirect("SuccessLogin.jsp");
        }
        else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red> Incorrect Credential(create Account)</font>");
            requestDispatcher.include(request,response);
        }
    }
}