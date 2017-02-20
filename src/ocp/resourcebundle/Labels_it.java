package ocp.resourcebundle;

import java.util.ListResourceBundle;

/**
 * Created by Madalin.Colezea on 2/20/2017.
 */
public class Labels_it extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"hello", new StringBuilder("hello java")}
        };
    }
}
