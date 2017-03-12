package ocp.questions;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Madalin on 12/03/2017.
 */
public class T1_Q5 {
    public static void main(String[] args) {

    }

    interface I1 {
        void m1() throws IOException;
    }

    interface I2 {
        void m1() throws SQLException;
    }

    class A implements I1, I2 {
        @Override
        public void m1() {

        }
    }
}
