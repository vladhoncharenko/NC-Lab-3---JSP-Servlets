package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for deleting Employees
 */
public class DeleteEmpl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=UTF-8");

        RequestDispatcher header = request.getRequestDispatcher("header.jsp");
        RequestDispatcher deleteEmployee = request.getRequestDispatcher("deleteEmployee.jsp");
        RequestDispatcher footer = request.getRequestDispatcher("footer.jsp");
        try {
            header.include(request, response);
            deleteEmployee.include(request,response);
            footer.include(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
