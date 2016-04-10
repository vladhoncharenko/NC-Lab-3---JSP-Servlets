package servlets;

import utils.ExecutePLSQL;
import utils.ResultSetDisplay;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Shows all departments from DB
 */
public class DeptntBrowserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ResultSet resultSet = null;
        ResultSetMetaData rsm = null;
        String query = "SELECT * FROM DEPTNT ORDER BY DEPTNO";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("header.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<title>Departments Browsing</title>");
        out.println("<h1 align=\"center\">Departments:</h1>");
        resultSet = ExecutePLSQL.executeQuery(query);
        ResultSetDisplay.displayEditDeleteDeptnt(resultSet, out);

        out.close();

        requestDispatcher = request.getRequestDispatcher("footer.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

}
