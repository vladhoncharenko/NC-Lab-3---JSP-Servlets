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

/**
 * Servlet for editing Employees
 */
public class EmplEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String deptntPage = "./employees";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("header.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        requestDispatcher = request.getRequestDispatcher("editEmpl.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int result = 0;
        String query = null;

        query = ("UPDATE EMPL SET ENAME='" + request.getParameter("ename") + "', JOB='" + request.getParameter("job") +
                "',HIREDATE= TO_DATE('" + request.getParameter("hiredate") + "','YYYY-MM-DD'),MGR=" + request.getParameter("mgr") +
                ",SAL=" + request.getParameter("sal") + ",COMM=" + request.getParameter("comm") + ",DEPTNO=" + request.getParameter("deptno") +
                " WHERE EMPNO= " + request.getParameter("emplNoF"));
        System.out.println(query);
        String execute = request.getParameter("RUNb");

        if (execute == null) {
            //no button has been selected
        } else if (execute.equals("Save")) {
            result = ExecutePLSQL.executeUpdate(query);
            response.sendRedirect(deptntPage);
        }
        out.close();

        requestDispatcher = request.getRequestDispatcher("footer.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e1) {
            e1.printStackTrace();
        }
    }
}
