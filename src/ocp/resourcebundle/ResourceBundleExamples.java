package ocp.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Madalin.Colezea on 2/20/2017.
 * 3 pasi:
 *  1. obtinere Locale
 *  2. obtinere ResourceBundle
 *  3. cautare valoare in ResourceBundle
 *  Reasons:
 *      - Be easily localized, or translated, into different languages
 *      - Handle multiple locales at once
 *      - Be easily modified later to support even more languages
 *  Search order:
 *      - full locale request (java then properties)
 *      - just language match (java then properties)
 *      - default locale
 *      - default bundle
 *      - throw MissingResourceException
 *  Erarhii:
 *      - nu se mostenesc intre java si fisiere de proprietati
 *      - parintele are intotdeauna un nume mai scurt decat copilul
 *      - se cauta mai intai in copil (mai specific) apoi in parinte
 */
public class ResourceBundleExamples {
    public static void main(String[] args) {
        Locale locale = new Locale("en");
        Locale locale2 = new Locale("fr");
        ResourceBundle rb = ResourceBundle.getBundle("Labels", locale);
        System.out.println(rb.getString("hello3"));
    }
}
