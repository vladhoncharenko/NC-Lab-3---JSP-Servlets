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
 * Servlet for adding Departments
 */
public class addDeptntServlet extends HttpServlet {
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
        out.println("<html><head><title>Add Department</title></head><body>");
        out.println("<form method=\"post\" action=\"/lab3/departmentadd\">");
        out.println("<h2>To add new department: Enter data in fields and press \"Add\"</h2>");

        out.println("<label for=\"dnameId\">Enter Name:</label>");
        out.println("<div><input type=\"text\" name=\"dname\" value=\"\" size=\"20\" id=\"dnameId\" /></div>");
        out.println("<label for=\"locId\">Enter Location:</label>");
        out.println("<div><input type=\"text\" name=\"loc\" value=\"\" size=\"20\" id=\"locId\" /></div>");

        out.println("<input type=\"submit\" name=\"RUNb\" value=\"Add\"/>");
        out.println("</form>");
        query = ("INSERT INTO DEPTNT(DNAME,LOC) VALUES('" + request.getParameter("dname") + "','" + request.getParameter("loc") + "')");
        String execute = request.getParameter("RUNb");

        if (execute == null) {
            //no button has been selected
        } else if (execute.equals("Add")) {

            if (request.getParameter("dname").length() > 13 || request.getParameter("loc").length() > 13) {
                out.println("<p>One of this values is too large for column. Max size:14 symbols. </p>");
            } else {
                if (request.getParameter("dname").length() == 0 || request.getParameter("loc").length() == 0) {
                    out.println("<p>None of these fields can be empty</p>");
                } else {
                    result = ExecutePLSQL.executeUpdate(query);
                    out.println("<p>" + result + " row(s) added</p>");
                }
                out.println("</table></body></html>");
                out.close();
            }

        }
        requestDispatcher = request.getRequestDispatcher("footer.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}