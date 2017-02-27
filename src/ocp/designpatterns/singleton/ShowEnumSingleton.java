package ocp.designpatterns.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madalin.Colezea on 2/23/2017.
 */
public class ShowEnumSingleton {
    public static void main(String[] args) {
        ShowEnum showEnum = ShowEnum.INSTANCE;
        System.out.println(showEnum.bookSeat("1A"));
        System.out.println(showEnum.bookSeat("1A"));
    }
}

enum ShowEnum {
    INSTANCE;

    private List<String> availableSeats;
    ShowEnum() {
        availableSeats = new ArrayList<>();
        availableSeats.add("1A");
        availableSeats.add("2A");
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
