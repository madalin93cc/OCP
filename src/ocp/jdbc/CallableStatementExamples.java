package ocp.jdbc;

import java.sql.*;

/**
 * Created by Madalin.Colezea on 3/10/2017.
 * Call types:
 *  - function: {? call <procedure_name> [(arg1, arg2, ...)]}
 *  - procedure: {call <procedure_name> [(arg1, arg2, ...)]}
 */
public class CallableStatementExamples {
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

            CallableStatement cs = connection.prepareCall("{call ? testProcedure(?, ?)}");
            cs.setInt(2, 2);
            cs.registerOutParameter(1, Types.INTEGER);
//            ResultSet rs = cs.executeQuery();
            cs.execute();
            while (cs.getMoreResults()) {
                // process
                ResultSet rs = cs.getResultSet();
            }
            cs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
