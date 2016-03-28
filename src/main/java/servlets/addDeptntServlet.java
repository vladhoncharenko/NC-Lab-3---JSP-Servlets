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
        out.println("<div><input type=\"text\" name=\"dname\" value=\"\" size=\"20\" id=\"dnameId\"" +
                " data-validation=\"length\" data-validation-length=\"1-13\"" +
                " data-validation-error-msg=\"Data is not valid. Please, enter 1-13 symbols.\" /></div>");
        out.println("<label for=\"locId\">Enter Location:</label>");
        out.println("<div><input type=\"text\" name=\"loc\" value=\"\" size=\"20\" id=\"locId\" " +
                "data-validation=\"length\" data-validation-length=\"1-13\"" +
                "data-validation-error-msg=\"Data is not valid. Please, enter 1-13 symbols.\" /></div>");

        out.println("<input type=\"submit\" name=\"RUNb\" value=\"Add\"/>");
        out.println("</form>");
        out.println("<script type=\"text/javascript\" src=\"//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>");
        out.println("<script type=\"text/javascript\" src=\"//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/jquery.form-validator.min.js\"></script>");
        out.println("<link href=\"//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/theme-default.min.css\"\n" +
                "    rel=\"stylesheet\" type=\"text/css\" />");
        out.println("<script>$.validate();</script>");

        int result = 0;
        String query = null;
        query = ("INSERT INTO DEPTNT(DNAME,LOC) VALUES('" + request.getParameter("dname") + "','" + request.getParameter("loc") + "')");
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