package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Models a mathematical set of integers with no duplicates.
 *
 * @author Selor
 */
public class IntegerSet {
    private final List<Integer> set;

    /**
     * Constructs an empty IntegerSet.
     */
    public IntegerSet() {
        this.set = new ArrayList<>();
    }

    /**
     * Removes all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return set size
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true when this set and the input set contain exactly the same
     * elements, regardless of internal order.
     *
     * @param b set to compare with
     * @return true when both sets contain the same elements
     */
    public boolean equals(IntegerSet b) {
        if (b == null) {
            return false;
        }
        if (this.length() != b.length()) {
            return false;
        }
        for (Integer value : set) {
            if (!b.contains(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the set contains the value.
     *
     * @param value value to search
     * @return true when value is in the set
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set.
     *
     * @return largest integer
     * @throws IllegalStateException when the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new IllegalStateException("IntegerSet is empty.");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in the set.
     *
     * @return smallest integer
     * @throws IllegalStateException when the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new IllegalStateException("IntegerSet is empty.");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already present.
     *
     * @param item value to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set when present.
     *
     * @param item value to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set containing all values from this set and intSetb.
     *
     * @param intSetb second set
     * @return union set
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (Integer value : this.set) {
            result.add(value);
        }
        if (intSetb != null) {
            for (Integer value : intSetb.set) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing values common to this set and intSetb.
     *
     * @param intSetb second set
     * @return intersection set
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        if (intSetb == null) {
            return result;
        }
        for (Integer value : this.set) {
            if (intSetb.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing values in this set but not in intSetb.
     *
     * @param intSetb second set
     * @return difference set (this - intSetb)
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (Integer value : this.set) {
            if (intSetb == null || !intSetb.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing values in intSetb but not in this set.
     *
     * @param intSetb second set
     * @return complement set (intSetb - this)
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        if (intSetb == null) {
            return result;
        }
        for (Integer value : intSetb.set) {
            if (!this.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Returns true when set has no elements.
     *
     * @return true when empty
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns set contents in ascending order with strict formatting:
     * [1, 2, 3]
     *
     * @return string representation of the set
     */
    @Override
    public String toString() {
        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}
