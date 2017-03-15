package ocp.jdbc;

import java.sql.*;

/**
 * Created by Madalin.Colezea on 3/10/2017.
 * Default:
 *  - autocommit - true
 *
 */
public class TransactionsExamples {
    static String url = "jdbc:mysql://localhost:3306/OCP";
    static String username = "root";
    static String password = "";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)){
            connection.setAutoCommit(false); // start transaction
            Statement statement = connection.createStatement();
            String q1 = "select * from Customer";
            String q2 = "select * from Customer";
            Savepoint sp = null;
            try {
                boolean b1 = statement.execute(q1);
                boolean b2 = statement.execute(q2);
                sp = connection.setSavepoint();

            } catch (SQLException e) {
                connection.rollback();
            }

            String q3 = "select * from AA";
            try {
                boolean b3 = statement.execute(q3);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback(sp);
                connection.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
