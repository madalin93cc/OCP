package ocp.date;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Madalin.Colezea on 11/7/2016.
 * constructors:
 *   - Locale(String language)
 *   - Locale(String language, String country)
 */
public class LocaleExamples {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2001, 11, 14);

        Date d = c.getTime();

        Locale locIT = new Locale("it", "IT"); // Italy
        Locale locPT = new Locale("pt"); // Portugal
        Locale locBR = new Locale("pt", "BR"); // Brazil
        Locale locIN = new Locale("hi", "IN"); // India
        Locale locJA = new Locale("ja"); // Japan
        Locale locDK = new Locale("da", "DK"); // Denmark

        DateFormat df1 = DateFormat.getInstance();
        System.out.println("Default: " + df1.format(d));

        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(df2.format(d));

        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, locIT);
        System.out.println(df3.format(d));

        DateFormat dfPT = DateFormat.getDateInstance(
                DateFormat.FULL, locPT);
        System.out.println("Portugal " + dfPT.format(d));
        DateFormat dfBR = DateFormat.getDateInstance(
                DateFormat.FULL, locBR);
        System.out.println("Brazil " + dfBR.format(d));
        DateFormat dfIN = DateFormat.getDateInstance(
                DateFormat.FULL, locIN);
        System.out.println("India " + dfIN.format(d));
        DateFormat dfJA = DateFormat.getDateInstance(
                DateFormat.FULL, locJA);
        System.out.println("Japan " + dfJA.format(d));

//        df1.setLocale(...)  nu exista

        System.out.println("def " + locBR.getDisplayCountry()); // countrt display name in def language
        System.out.println(locBR.getDisplayCountry(locBR));
        System.out.println(locBR.getDisplayCountry(locIT)); // country display name in locale language

        System.out.println("def " + locDK.getDisplayLanguage());
        System.out.println("loc " + locDK.getDisplayLanguage(locDK));
        System.out.println("D>I " + locDK.getDisplayLanguage(locIT));
    }
}
