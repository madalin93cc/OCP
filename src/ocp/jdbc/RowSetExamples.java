package ocp.jdbc;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

/**
 * Created by Madalin.Colezea on 3/10/2017.
 */
public class RowSetExamples {
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
            RowSetFactory rsf = RowSetProvider.newFactory();
            JdbcRowSet rowSet = rsf.createJdbcRowSet();
            // connected RowSet
            rowSet.addRowSetListener(new RowSetListener() {
                @Override
                public void rowSetChanged(RowSetEvent event) {
                    System.out.println("Row set changed");
                }

                @Override
                public void rowChanged(RowSetEvent event) {
                    System.out.println("Row changed");
                    if (event.getSource() instanceof RowSet) {
                        try {
                            ((RowSet) event.getSource()).execute();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }

                @Override
                public void cursorMoved(RowSetEvent event) {
                    System.out.println("Cursor moved");
                }
            });
            rowSet.setUrl(url);
            rowSet.setPassword(password);
            rowSet.setUsername(username);
            rowSet.setCommand("select * from Customer");
            rowSet.execute();
            while (rowSet.next()) {
                System.out.println(rowSet.getString("FirstName"));
            }
            rowSet.last();
            rowSet.updateString("FirstName", "FirstX");
            rowSet.updateRow();
            rowSet.beforeFirst();
            while (rowSet.next()) {
                System.out.println(rowSet.getString("FirstName"));
            }
            rowSet.moveToInsertRow();
            rowSet.updateInt(1, 4);
            rowSet.updateString(2, "F");
            rowSet.updateString(3, "L");
            rowSet.updateString(4, "email");
            rowSet.updateString(5, "000");
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
            rowSet.last();
            rowSet.deleteRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            RowSetFactory rsf = RowSetProvider.newFactory();
            CachedRowSet crs = rsf.createCachedRowSet();
            crs.setCommand("select * from Customer;");
            crs.setUrl(url);
            crs.setUsername(username);
            crs.setPassword(password);
            crs.execute();

            crs.next();
            crs.deleteRow();
            crs.acceptChanges();
            crs.beforeFirst();
            while (crs.next()) {
                System.out.println(crs.getString("FirstName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
