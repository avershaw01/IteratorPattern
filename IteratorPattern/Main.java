package IteratorPattern;

import java.util.Iterator;

public class Main {
    public static void iterateStrategy(Iterator<Integer> it) {
        /*
        In this method, the user may decide what to do while it iterates
        The parameter passed in dictates whether it will iterate forwards or backwards
         */
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        // This is a generic example of a usage of the iterator.

        // Class Object s is created and populated with an ArrayList {1, 2, 3, 4, 5}
        Stuff s = new Stuff();
        s.addItem(1);
        s.addItem(2);
        s.addItem(3);
        s.addItem(4);
        s.addItem(5);

        // Makes two calls to the iterateStrategy
        System.out.println("Printing Forwards");
        iterateStrategy(s.forwardIterator());

        System.out.println("Printing Backwards");
        iterateStrategy(s.backwardIterator());
    }
}
