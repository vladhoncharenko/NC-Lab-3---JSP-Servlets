package servlets;

import utils.ExecutePLSQL;

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
public class AddEmplServlet extends HttpServlet {
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

        requestDispatcher = request.getRequestDispatcher("addEmpl.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        query = ("INSERT INTO EMPL(ENAME,JOB,HIREDATE,MGR,SAL,COMM,DEPTNO) VALUES ('" + request.getParameter("ename")
                + "','" + request.getParameter("job") + "',TO_DATE('" + request.getParameter("hiredate") + "','YYYY-MM-DD')," +
                request.getParameter("mgr") + "," + request.getParameter("sal") + "," + request.getParameter("comm") + "," +
                request.getParameter("deptno") + ")");
        System.out.println(query);
        String execute = request.getParameter("RUNb");
        if (execute == null) {
            //no button has been selected
        } else if (execute.equals("Add")) {

            result = ExecutePLSQL.executeUpdate(query);
            out.println("<p>" + result + " row(s) added</p>");
        }

        out.close();

        requestDispatcher = request.getRequestDispatcher("footer.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}