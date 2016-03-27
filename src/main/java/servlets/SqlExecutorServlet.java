package servlets;

import dataBaseUtils.WebLogicDbConnect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SqlExecutorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        process(request, response);

    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsm = null;
        RequestDispatcher rd = request.getRequestDispatcher("header.jsp");
        try {
            rd.include(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html><head><title>Database SQL Executor</title></head><body>");
        out.println("<form method=\"post\" action=\"/lab3/execute\">");
        out.println("<h2>Enter query in input area and press button \"Enter\"</h2>");
        if (request.getParameter("query") == null) {
            out.println("<input type=\"text\" name=\"query\" value=\"\" size=\"100\" />");
        } else {
            out.println("<input type=\"text\" name=\"query\" value=\"" + request.getParameter("query") + "\" size=\"100\" />");
        }

        out.println("<input type=\"submit\" name=\"RUNb\" value=\"RUN\"/>");
        out.println("</form>");

        String execute = request.getParameter("RUNb");
        if (execute == null) {
            //no button has been selected
        } else if (execute.equals("RUN")) {
            out.println("<table border='1'><tr>");

            try {

                conn = WebLogicDbConnect.getConnect();
                stmt = conn.createStatement();

                rs = stmt.executeQuery(request.getParameter("query"));
                rsm = rs.getMetaData();
                int colCount = rsm.getColumnCount();

                //print column names
                for (int i = 1; i <= colCount; ++i) {

                    out.println("<th>" + rsm.getColumnName(i) + "</th>");
                }

                out.println("</tr>");
                //print data
                while (rs.next()) {

                    out.println("<tr>");

                    for (int i = 1; i <= colCount; ++i)
                        out.println("<td>" + rs.getString(i) + "</td>");

                    out.println("</tr>");
                }

            } catch (Exception e) {

                try {
                    throw new ServletException(e.getMessage());
                } catch (ServletException e1) {
                    e1.printStackTrace();
                }

            } finally {

                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }

                } catch (SQLException e) {
                    System.out.println("SQLException");
                }

            }
        }


        out.println("</table></body></html>");
        out.close();
//        rd = request.getRequestDispatcher("footer.jsp");
//        try {
//            rd.include(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }

    }
}




