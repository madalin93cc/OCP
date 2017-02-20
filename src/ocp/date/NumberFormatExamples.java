package ocp.date;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Madalin.Colezea on 11/7/2016.
 * getInstance
 * getCurrencyInstance
 */
public class NumberFormatExamples {
    public static void main(String[] args) {
        float f1 = 123.4567f;
        Locale l1 = new Locale("fr");
        NumberFormat[] nfr = new NumberFormat[4];

        nfr[0] = NumberFormat.getInstance();
        nfr[1] = NumberFormat.getInstance(l1);
        nfr[2] = NumberFormat.getCurrencyInstance();
        nfr[3] = NumberFormat.getCurrencyInstance(l1);

        System.out.println(nfr[0].format(f1));
        System.out.println(nfr[1].format(f1));
        System.out.println(nfr[2].format(f1));
        System.out.println(nfr[3].format(f1));

        System.out.println(nfr[0].getMaximumFractionDigits());
        nfr[0].setMaximumFractionDigits(5);
        System.out.println(nfr[0].format(f1));
        try {
            System.out.println(nfr[0].parse("1255.456"));
            nfr[0].setParseIntegerOnly(true);
            System.out.println(nfr[0].parse("1255.456"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        String s = "987.123456";
        double d = 987.123456d;

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(5);
        System.out.print(nf.format(d) + " ");
        try {
            System.out.println(nf.parse(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
