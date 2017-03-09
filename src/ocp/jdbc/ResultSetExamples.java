package ocp.jdbc;

import java.sql.*;

import static java.lang.System.out;
import static java.lang.System.setOut;

/**
 * Created by Madalin.Colezea on 3/9/2017.
 * - public boolean next(): muta cursorul in fata si returneaza true daca pointeaza la un row
 * -
 */
public class ResultSetExamples {
    static String url = "jdbc:mysql://localhost:3306/OCP";
    static String username = "root";
    static String password = "";

    public static void main(String[] args) throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

//        moving forward example + read data
        String query = "select * from Customer";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            out.print(rs.getInt("CustomerID"));
            out.print(" " + rs.getString("FirstName"));
            out.print(" " + rs.getString("LastName"));
            Object o = rs.getObject("EMail");
            if (o instanceof String) {
                out.print(" " + (String) o);
            }
            out.println(" " + rs.getString("Phone"));

            out.print(rs.getInt(1));
            out.print(" " + rs.getString(2));
            out.print(" " + rs.getString(3));
            out.print(" " + rs.getString(4));
            out.println(" " + rs.getString(5));
        }

//        print report like
        ResultSet rs2 = statement.executeQuery(query);
        ResultSetMetaData rsmd = rs2.getMetaData();
        int colNum = rsmd.getColumnCount();
        for (int i = 1; i <= colNum; i++) {
            out.print(rsmd.getTableName(i) + ":" + rsmd.getColumnName(i) + ":" + rsmd.getColumnLabel(i) + ":" + rsmd.getColumnTypeName(i) + ":" + rsmd.getColumnDisplaySize(i) + " ");
        }
        out.println();
        String rez;
        while (rs2.next()) {
            for (int i = 1; i <= colNum; i++) {
                Object o = rs2.getObject(i);
                if (o != null) {
                    rez = o.toString() + " ";
                } else {
                    rez = "NULL";
                }
                out.print(rez);
            }
            out.println();
        }
    }
}

