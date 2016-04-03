package utils;


import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Allows to work with ResultSet
 */

public class ResultSetDisplay {

    /**
     * Displays ResultSet content in the html table
     *
     * @param resultSet ResultSet
     * @param out       PrintWriter
     */
    public static void display(ResultSet resultSet, PrintWriter out) {

        ResultSetMetaData resultSetMetaData;


        try {

            resultSetMetaData = resultSet.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();

            //print column names
            out.println("<table border='1'><tr>");
            for (int i = 1; i <= colCount; ++i) {

                out.println("<th>" + resultSetMetaData.getColumnName(i) + "</th>");
            }
            out.println("</tr>");
            //print data
            while (resultSet.next()) {

                out.println("<tr>");

                for (int i = 1; i <= colCount; ++i)
                    out.println("<td>" + resultSet.getString(i) + "</td>");

                out.println("</tr>");
            }
            out.println("</table>");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayEditDeleteDeptnt(ResultSet resultSet, PrintWriter out) {
        ResultSetMetaData resultSetMetaData;
        int i = 0;

        try {

            resultSetMetaData = resultSet.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();

            //print column names
            out.println("<p align=\"center\">");
            out.println("<table border='1'><tr>");
            for (i = 1; i <= colCount; ++i) {

                out.println("<th>" + resultSetMetaData.getColumnName(i) + "</th>");
            }

            out.println("<th>Edit</th>");
            out.println("<th>Delete</th>");

            out.println("</tr>");
            //print data
            while (resultSet.next()) {

                out.println("<tr>");

                for (i = 1; i <= colCount; ++i)
                    out.println("<td>" + resultSet.getString(i) + "</td>");

                out.println("<td> <form action=\"/lab3/updatedepartment\" method=\"post\"> <input type=\"hidden\" name=\"deptntNoField\" value=\"" + resultSet.getString(1) + "\"> <input  type=\"submit\"  name=\"deptntNo\"  value=\"Edit\"></form></td>");
                out.println("<td> <form action=\"/lab3/deletedepartment\" method=\"post\"> <input type=\"hidden\" name=\"deptntNoField\" value=\"" + resultSet.getString(1) + "\"> <input  type=\"submit\"  name=\"deptntNo\"  value=\"Delete\"></form></td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</p>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns rows amount in ResultSet
     *
     * @param resultSet
     * @return rows amount in ResultSet
     */
    public static int getSelectedRowsAmount(ResultSet resultSet) {
        int amount = 0;
        try {
            while (resultSet.next()) {
                amount++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amount;

    }
}

