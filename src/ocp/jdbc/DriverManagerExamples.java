package ocp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Madalin.Colezea on 3/8/2017.
 * Workflow:
 *  - driver manager cauta in classpath fisiere cu numele java.sql.Driver in META-INF/services si incarca toate clasele gasite
 *  - clasa Driver are un bloc static de initializare care apeleaza metoda registerDriver din DriverManager cu o instanta a ei
 *  - metoda getConnection incearca metoda connect din fiecare Driver inregistrat si din prima care merge intoarce o instanta de Connection
 * URL:
 *  - format: jdbc:<subprotocol>:<subname>
 *         subprotocol -> vendor
 *         subname -> vendor specific
 */
public class DriverManagerExamples {
    public static void main(String[] args) {

        try {
//        for JDBC 3.0 or older
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            String url = "jdbc:mysql://localhost:3306/MyDB";
            String username = "user";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
