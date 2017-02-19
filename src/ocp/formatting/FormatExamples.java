package ocp.formatting;

/**
 * Created by Madalin on 19/02/2017.
 * General form: %[arg_index$][flags][width][.precision]conversion char
 * flags: - left-justify
 *        + include a sign
 *        0 pad with zero
 *        , use local specific grouping separators
 *        ( enclose negative numbers in parentheses
 * conversion: b boolean
 *             c char
 *             d integer
 *             f floating point
 *             s string
 */
public class FormatExamples {
    public static void main(String[] args) {
        System.out.printf("%1$0,9.2f", -123.4567);
    }
}
