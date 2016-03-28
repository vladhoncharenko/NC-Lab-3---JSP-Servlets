package servlets;

import dataBaseUtils.ResultSetDisplay;
import dataBaseUtils.WebLogicDbConnect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData rsm = null;

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("header.jsp");
        try {
            requestDispatcher.include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
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

            try {

                connection = WebLogicDbConnect.getConnect();
                preparedStatement = connection.prepareStatement(request.getParameter("query"));
                resultSet = preparedStatement.executeQuery();
                ResultSetDisplay.display(resultSet, out);

            } catch (Exception e) {

                try {
                    throw new ServletException(e.getMessage());
                } catch (ServletException e1) {
                    e1.printStackTrace();
                }
            } finally {

                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }

                } catch (SQLException e) {
                    System.out.println("SQLException");
                }

            }

            out.println("</table></body></html>");
            out.close();
//        requestDispatcher = request.getRequestDispatcher("footer.jsp");
//        try {
//            requestDispatcher.include(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }

        }
    }
}




