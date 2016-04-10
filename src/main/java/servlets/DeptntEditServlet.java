package servlets;

import utils.ExecutePLSQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeptntEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String deptntPage = "./departments";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("header.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        requestDispatcher = request.getRequestDispatcher("editDeptnt.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int result = 0;
        String query = null;

        query = (" UPDATE DEPTNT SET DNAME='" + request.getParameter("dname") + "', LOC='" + request.getParameter("loc") + "' WHERE DEPTNO = '" + request.getParameter("DeptntNoF") + "'");
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

