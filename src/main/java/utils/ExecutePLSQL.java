package utils;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class allows to work with PLSQL execution
 */
public class ExecutePLSQL {

    /**
     * Executes Select PLSQL query
     *
     * @param query query to execute
     * @return ResultSet
     */
    public static ResultSet executeQuery(String query) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        CachedRowSetImpl cachedRowSet = null;
        try {
            cachedRowSet = new CachedRowSetImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            connection = WebLogicDbConnect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            assert cachedRowSet != null;
            cachedRowSet.populate(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println("SQLException");
            }

        }

        return cachedRowSet;
    }

    /**
     * Executes Update PLSQL query
     *
     * @param query query to execute
     * @return int number of rows affected by the query
     */
    public static int executeUpdate(String query) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;

        try {
            connection = WebLogicDbConnect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
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

        return result;
    }
}
