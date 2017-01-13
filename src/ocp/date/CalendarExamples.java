package ocp.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Madalin.Colezea on 11/7/2016.
 */
public class CalendarExamples {
    public static void main(String[] args) {
//        is abstract
//        Calendar calendar = new Calendar();
        Date d = new Date(1_000_000_000_000L);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d);
        System.out.println(c1.getTime());
        if (Calendar.SUNDAY == c1.getFirstDayOfWeek()) {
            System.out.println("Sunday is first day " + c1.get(Calendar.DAY_OF_WEEK));
        }
        c1.add(Calendar.MONTH, 1);
        System.out.println(c1.getTime());
//        ca fel ca add dar nu modifica unitatile mai mari
        c1.roll(Calendar.MONTH, 12);
        System.out.println(c1.getTime());
    }
}
