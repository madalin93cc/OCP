package ocp.designpatterns.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madalin.Colezea on 2/23/2017.
 */
public class ShowSingleton {
    public static void main(String[] args) {
        Show show = Show.getInstance();
        System.out.println(show.bookSeat("1A"));
        System.out.println(show.bookSeat("1A"));
    }
}

class Show {
    private static Show INSTANCE = null;
    private List<String> availableSeats;

    private Show() {
        availableSeats = new ArrayList<>();
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public static Show getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Show();
        }
        return INSTANCE;
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
