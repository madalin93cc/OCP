package ocp.jdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Madalin.Colezea on 3/10/2017.
 */
public class SQLExceptionExamples {
    static String url = "jdbc:mysql://localhost:3306/OCP";
    static String username = "root";
    static String password = "";

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("ocp.jdbc.SQLExceptionExamples");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select * from Author where AuthorID = 1;";
            ResultSet rs = statement.executeQuery(query);
            SQLWarning warning = connection.getWarnings();
            while (warning != null) {
                logger.log(Level.WARNING, "Code: " + warning.getErrorCode());
                logger.log(Level.WARNING, "Code: " + warning.getMessage());
                warning = warning.getNextWarning();
            }
        } catch (SQLException e) {
            while (e != null) {
                logger.log(Level.SEVERE, "SQLError: " + e);
                logger.log(Level.SEVERE, "State: " + e.getSQLState());
                logger.log(Level.SEVERE, "Code: " + e.getErrorCode());
                logger.log(Level.SEVERE, "Message: " + e.getMessage());
                e = e.getNextException();
            }
        }

//        close resources
        try (Connection c = DriverManager.getConnection(url, username, password);
             Statement stmt = c.createStatement()
             ){
            ResultSet rs = stmt.executeQuery("select * from Customer where CustomerID = 1;");

            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }

            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Throwable[] throwables = e.getSuppressed();
            for (Throwable t: throwables) {
                System.out.println(t.getMessage());
            }
        }
    }
}
