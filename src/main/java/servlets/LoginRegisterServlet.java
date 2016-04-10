package servlets;

import utils.ExecutePLSQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Login/Register Servlet
 */
@WebServlet(name = "LoginRegisterServlet")
public class LoginRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            processPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }
    private void process(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=UTF-8");

        RequestDispatcher header = request.getRequestDispatcher("header.jsp");
        RequestDispatcher content = request.getRequestDispatcher("login.jsp");
        RequestDispatcher footer = request.getRequestDispatcher("footer.jsp");
        try {
            header.include(request, response);
            content.include(request,response);
            footer.include(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processPost(HttpServletRequest request,HttpServletResponse response) {
        String uname = request.getParameter("uname");
        String password = request.getParameter("pass");
        if (request.getParameter("login") != null) {
            ResultSet rs = ExecutePLSQL.executeQuery("SELECT * FROM USERS WHERE USERNAME='" + uname + "' AND " +
                    "PASSWORD='" + password + "'");
            try {
                if (rs.next()) {
                    request.getSession().setAttribute("uname", uname);
                    request.getSession().setAttribute("empno",rs.getString("EMPNO"));
                    response.sendRedirect("employees");
                }
                else{
                    request.getSession().setAttribute("loginfail","loginfail");
                    response.sendRedirect("login");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (request.getParameter("register") != null) {
            try {
                uname= request.getParameter("reguname");
                password = request.getParameter("regemail");
                ResultSet rs = ExecutePLSQL.executeQuery("SELECT * FROM USERS WHERE USERNAME='" + uname + "' OR " +
                        "EMAIL='" + password + "'" + " OR " + "EMPNO = "+ request.getParameter("regid"));
                if(rs.next()){
                    request.getSession().setAttribute("fail","failure");
                    response.sendRedirect("login");
                }
                else {
                    System.out.println("INSERT INTO USERS VALUES(" + request.getParameter("regid") +
                            ",'" + request.getParameter("reguname") + "','" + request.getParameter("regpass") + "','" +
                            request.getParameter("regemail") + "',SYSDATE)");
                    ExecutePLSQL.executeUpdate("INSERT INTO USERS VALUES(" + request.getParameter("regid") +
                            ",'" + request.getParameter("reguname") + "','" + request.getParameter("regpass") + "','" +
                            request.getParameter("regemail") + "',SYSDATE)");
                    response.sendRedirect("login");
                    request.getSession().setAttribute("reg", "success");
                }
//
//

            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
