package ocp.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Madalin.Colezea on 2/20/2017.
 */
public class ResourceBundleClassExample {
    public static void main(String[] args) {
        Locale locale = new Locale("it");
        ResourceBundle rb = ResourceBundle.getBundle("Labels", locale);
        System.out.println(rb.getObject("hello"));
    }
}
