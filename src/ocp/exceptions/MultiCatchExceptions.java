package ocp.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Madalin.Colezea on 10/31/2016.
 */
public class MultiCatchExceptions {
    public static void main(String[] args) throws IOException {
        try {
            if (true)
                throw new FileNotFoundException();
            else
                throw new SQLException();
        }
//        catch (FileNotFoundException | SQLException e) {
//            only for exceptions from different inheritance hierarchies
//            e.printStackTrace();
//        }
//        catch (FileNotFoundException e) {
//            e = new FileNotFoundException();
//            COMPILE
//        }
        catch(FileNotFoundException | SQLException e) {

        }
//        numele variabilei o singura data
//        catch (FileNotFoundException e1 | IllegalArgumentException e2) {
//
//        }

        try {
            new MultiCatchExceptions().method();
        } catch (Exception e) {
            throw e;
        }
    }

    void method() throws IOException {}
}
