package ocp.collections.sorting;

import java.util.*;

/**
 * Created by Madalin on 27/02/2017.
 */
public class CollectionsSortComparaleExamples {
    public static void main(String[] args) {
        final DVD dvd1 = new DVD("X", "1asda");
        DVD dvd2 = new DVD("V", "asda");
        List<DVD> dvds = new ArrayList();
        dvds.add(dvd1);
        dvds.add(dvd2);
        System.out.println(dvds);
        Collections.sort(dvds);
        System.out.println(dvds);
        DVDComparator dvdComparator = new DVDComparator();
        Collections.sort(dvds, dvdComparator);
        System.out.println(dvds);

        String [] strings = new String[] {"D", "F", "C"};
        System.out.println(strings);
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, new StringReverse());
        System.out.println(Arrays.toString(strings));

        int [] ints = new int[] {2, 6, 3};
        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}

class StringReverse implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return (-1) * s1.compareTo(s2);
    }
}

class DVDComparator implements Comparator<DVD> {
    @Override
    public int compare(DVD dvd1, DVD dvd2) {
        return dvd1.getAuthor().compareTo(dvd2.getTitle());
    }
}

class DVD implements Comparable<DVD> {
    private String title;
    private String author;

    public DVD(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int compareTo(DVD other) {
        return title.compareTo(other.getTitle());
    }

    @Override
    public String toString() {
        return title + " " + author;
    }
}