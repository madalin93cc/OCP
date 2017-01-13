package ocp.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Madalin.Colezea on 11/7/2016.
 */
public class DateExamples {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());

        Date d2 = new Date(1_000_000_000_000L);
        System.out.println(d2);
//       singurele metode folosite (nedeprecated)
        d2.setTime(d2.getTime() + 3_600_000L);
        System.out.println(d2);
    }
}
