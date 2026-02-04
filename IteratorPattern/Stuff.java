package IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stuff {
    // This class demonstrates the Iterator pattern using an ArrayList of Integers
    private ArrayList<Integer> items = new ArrayList<>();

    // Generic methods only used for demonstrating the iterator pattern
    public void addItem(int item) {
        items.add(item);
    }

    public int size() {
        return items.size();
    }

    // Override to prevent mutation during iteration
    public void remove() {
        throw new UnsupportedOperationException("Mutations not allowed");
    }

    // Constructors for the Iterator classes
    public Iterator<Integer> forwardIterator() {
        return new ForwardIterator();
    }
    public Iterator<Integer> backwardIterator() {
        return new BackwardIterator();
    }

    // A class within a class to hold both the forward and backward iterators
    private class ForwardIterator implements Iterator<Integer> {
        private int index = 0;

        public boolean hasNext() {
            return (index < items.size());
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items.get(index++);
        }
    }

    private class BackwardIterator implements Iterator<Integer> {
        private int index = items.size() - 1;

        public boolean hasNext() {
            return (index >= 0);
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items.get(index--);
        }
    }
}
