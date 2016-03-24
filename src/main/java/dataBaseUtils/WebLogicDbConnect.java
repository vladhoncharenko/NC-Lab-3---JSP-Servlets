package dataBaseUtils;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

public class WebLogicDbConnect {
    static DataSource dataSource;

    /**
     * Returns connection instance
     * Uses "firstOracleDataSource" data source object
     * @return connection
     */
    public static Connection getConnect(){
        Context context = null;
        Connection connection=null;

        Hashtable hashTable = new Hashtable();
        hashTable.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");

        //Default:
        //hashTable.put(Context.PROVIDER_URL,"t3://localhost:7001");

        try {

            context = new InitialContext(hashTable);
            dataSource = (javax.sql.DataSource) context.lookup("firstOracleDataSource");

            if (dataSource == null)
                throw new ServletException("'firstOracleDataSource' is an unknown DataSource");

        } catch (NamingException ne) {

            try {
                throw new ServletException(ne);
            } catch (ServletException e) {
                e.printStackTrace();
            }

        } catch (ServletException e) {
            e.printStackTrace();
        }


        try {
              connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

