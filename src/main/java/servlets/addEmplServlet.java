package servlets;

import dataBaseUtils.ExecutePLSQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet for adding Employees
 */
public class addEmplServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int result = 0;
        String query = null;

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("header.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Add Employee</title></head><body>");
        out.println("<form method=\"post\" action=\"/lab3/employeeadd\">");
        out.println("<h2>To add new department: Enter data in fields and press \"Add\"</h2>");

        out.println("<label for=\"enameId\">Name:</label>");
        out.println("<div><input type=\"text\" name=\"ename\" value=\"\" size=\"20\" id=\"enameId\" /></div>");

        out.println("<label for=\"jobId\">Job:</label>");
        out.println("<div><input type=\"text\" name=\"job\" value=\"\" size=\"20\" id=\"jobId\" /></div>");

        out.println("<label for=\"hiredateId\">Hire Date:</label>");
        out.println("<div><input type=\"text\" name=\"hiredate\" value=\"\" size=\"20\" id=\"hiredateId\" /></div>");

        out.println("<label for=\"mgrId\">Manager's Id:</label>");
        out.println("<div><input type=\"text\" name=\"mgr\" value=\"\" size=\"20\" id=\"mgrId\" /></div>");

        out.println("<label for=\"salId\">Salary:</label>");
        out.println("<div><input type=\"text\" name=\"sal\" value=\"\" size=\"20\" id=\"salId\" /></div>");

        out.println("<label for=\"commId\">Commissions:</label>");
        out.println("<div><input type=\"text\" name=\"comm\" value=\"\" size=\"20\" id=\"commId\" /></div>");

        out.println("<label for=\"deptnoId\">Department Number:</label>");
        out.println("<div><input type=\"text\" name=\"deptno\" value=\"\" size=\"20\" id=\"deptnoId\" /></div>");


        out.println("<input type=\"submit\" name=\"RUNb\" value=\"Add\"/>");
        out.println("</form>");

        query = ("INSERT INTO EMPL(ENAME,JOB,HIREDATE,MGR,SAL,COMM,DEPTNO) VALUES ('" + request.getParameter("ename") +
                "','" + request.getParameter("job") + "',TO_DATE('" + request.getParameter("hiredate") + "','YYYY-MM-DD')," +
                request.getParameter("mgr") + "," + request.getParameter("sal") + "," + request.getParameter("comm") + "," +
                request.getParameter("deptno") + ")");
        String execute = request.getParameter("RUNb");

        if (execute == null) {
            //no button has been selected
        } else if (execute.equals("Add")) {

            result = ExecutePLSQL.executeUpdate(query);
            out.println("<p>" + result + " row(s) added</p>");
        }
        out.println("</table></body></html>");
        out.close();

        requestDispatcher = request.getRequestDispatcher("footer.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}