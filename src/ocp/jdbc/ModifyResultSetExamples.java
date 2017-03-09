package ocp.jdbc;

import java.sql.*;

/**
 * Created by Madalin.Colezea on 3/9/2017.
 * ResoultSet coursor types:
 *  - TYPE_FORWARD_ONLY
 *  - TYPE_SCROLL_INSENSITIVE: forward, backward, position dar datele modificate in baza nu se reflecta in datele din rezultset
 *  - TYPE_SCROLL_SENSITIVE: forward, backward, position datele modificate in baza se reflecta in datele din rezultset
 *
 *  ResultSet Data concurency:
 *  - CONCUR_READ_ONLY: un result set nu poate fi modificat
 *  - CONCUR_UPDATABLE: rezultset-ul se poate modifica
 */
public class ModifyResultSetExamples {
    static String url = "jdbc:mysql://localhost:3306/OCP";
    static String username = "root";
    static String password = "";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection c = DriverManager.getConnection(url, username, password);
            DatabaseMetaData dbmd = c.getMetaData();
            if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.print("Supports forward only");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" and concur updatable");
                }
            }

            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.print("Supports scroll insensitive");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" and concur updatable");
                }
            }

            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.print("Supports concur sensitive");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" and concur updatable");
                }
            }

            Statement statement = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
