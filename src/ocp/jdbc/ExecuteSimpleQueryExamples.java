package ocp.jdbc;

import java.sql.*;

import static java.lang.System.*;

/**
 * Created by Madalin.Colezea on 3/9/2017.
 * public ResultSet executeQuery(String sql) throws SqlException - cand stim ca intoarce date
 * public int executeUpdate(String sql) throws SqlException - afecteaza unul sau mai multe randuri si nu intoarce un rezultat
 *                                                          -(INSERT, UPDATE, DELETE SI DDL)
 *                                                          - intoarce numarul de randuri afectate
 * public boolean execute(String sql) throws SqlException - cand nu stiu ce o sa intoarca, query-uri construite dinamic
 *                                                        - intoarce true daca query-ul a intors result set
 *                                                        - intoarce false daca query-ul a intors nr de randuri afectate
 *                                                        - adesea folosita cu proceduri stocate
 */
public class ExecuteSimpleQueryExamples {
    static String url = "jdbc:mysql://localhost:3306/OCP";
    static String username = "root";
    static String password = "";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        executeQuery example
        String query = "select * from Customer";
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                out.print(rs.getInt("CustomerID"));
                out.print(" " + rs.getString("FirstName"));
                out.print(" " + rs.getString("LastName"));
                out.print(" " + rs.getString("EMail"));
                out.println(" " + rs.getString("Phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        executeUpdate example
        String query1 = "update Customer set Phone = 11122 where CustomerID = 1";
        try {
            int numRows = statement.executeUpdate(query1);
            out.println("Number of rows updated: " + numRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        execute example
        try {
            boolean rez = statement.execute(query1);
            if (rez) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    out.print(rs.getInt("CustomerID"));
                    out.print(" " + rs.getString("FirstName"));
                    out.print(" " + rs.getString("LastName"));
                    out.print(" " + rs.getString("EMail"));
                    out.println(" " + rs.getString("Phone"));
                }
            } else {
                int count = statement.getUpdateCount();
                if (count != -1)
                    out.println("Count: " + count);
                else
                    out.println("No rezults");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
