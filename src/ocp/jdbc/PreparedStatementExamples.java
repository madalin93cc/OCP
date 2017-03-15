package ocp.jdbc;

import java.sql.*;

/**
 * Created by Madalin.Colezea on 3/10/2017.
 */
public class PreparedStatementExamples {
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

            PreparedStatement ps = connection.prepareStatement("select * from Customer where CustomerID = ?");
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("FirstName"));
            }

            if (rs != null && ps != null) {
                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
