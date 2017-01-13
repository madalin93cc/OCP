package ocp.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by Madalin.Colezea on 11/7/2016.
 */
public class DateFormatExamples {
    public static void main(String[] args) {
        Date d = new Date(1_000_000_000_000L);

        DateFormat[] dfa = new DateFormat[9];
        dfa[0] = DateFormat.getInstance();
        dfa[1] = DateFormat.getDateInstance();
        dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
        dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);
        dfa[6] = DateFormat.getDateInstance(DateFormat.DEFAULT);
        dfa[7] = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        dfa[8] = DateFormat.getTimeInstance(DateFormat.SHORT);
        for (DateFormat df: dfa) {
            System.out.println(df.format(d));
        }

        String s = dfa[1].format(d);
        try {
//            trebuie sa aiba acelasi format cu df-ul altfel crapa cu unparsable exception
            Date d2 = dfa[1].parse(s);
            System.out.println(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
