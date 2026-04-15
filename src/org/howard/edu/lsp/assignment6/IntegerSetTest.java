package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * JUnit 5 tests for {@link IntegerSet}. Each method has normal and edge coverage.
 *
 * @author Selor
 */
class IntegerSetTest {

    @Test
    void clear_normal_removesAllElements() {
        IntegerSet s = new IntegerSet();
        s.add(1);
        s.add(2);
        s.clear();
        assertTrue(s.isEmpty());
        assertEquals(0, s.length());
    }

    @Test
    void clear_edge_alreadyEmptyStaysEmpty() {
        IntegerSet s = new IntegerSet();
        s.clear();
        assertTrue(s.isEmpty());
        assertEquals("[]", s.toString());
    }

    @Test
    void length_normal_matchesAddedDistinctElements() {
        IntegerSet s = new IntegerSet();
        s.add(10);
        s.add(20);
        s.add(30);
        assertEquals(3, s.length());
    }

    @Test
    void length_edge_emptySetIsZero() {
        assertEquals(0, new IntegerSet().length());
    }

    @Test
    void equals_edge_sameElementsDifferentOrder() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        a.add(3);
        IntegerSet b = new IntegerSet();
        b.add(3);
        b.add(1);
        b.add(2);
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
    }

    @Test
    void equals_edge_mismatchDifferentSizes() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        a.add(3);
        IntegerSet b = new IntegerSet();
        b.add(1);
        b.add(2);
        assertFalse(a.equals(b));
    }

    @Test
    void contains_normal_valuePresent() {
        IntegerSet s = new IntegerSet();
        s.add(5);
        assertTrue(s.contains(5));
    }

    @Test
    void contains_edge_valueNotPresent() {
        IntegerSet s = new IntegerSet();
        s.add(1);
        assertFalse(s.contains(99));
    }

    @Test
    void largest_normal_multipleElements() {
        IntegerSet s = new IntegerSet();
        s.add(3);
        s.add(1);
        s.add(2);
        assertEquals(3, s.largest());
    }

    @Test
    void largest_edge_singleElement() {
        IntegerSet s = new IntegerSet();
        s.add(42);
        assertEquals(42, s.largest());
    }

    @Test
    void largest_edge_emptyThrows() {
        IntegerSet s = new IntegerSet();
        assertThrows(IllegalStateException.class, s::largest);
    }

    @Test
    void smallest_normal_multipleElements() {
        IntegerSet s = new IntegerSet();
        s.add(3);
        s.add(1);
        s.add(2);
        assertEquals(1, s.smallest());
    }

    @Test
    void smallest_edge_singleElement() {
        IntegerSet s = new IntegerSet();
        s.add(7);
        assertEquals(7, s.smallest());
    }

    @Test
    void smallest_edge_emptyThrows() {
        IntegerSet s = new IntegerSet();
        assertThrows(IllegalStateException.class, s::smallest);
    }

    @Test
    void add_normal_increasesSet() {
        IntegerSet s = new IntegerSet();
        s.add(1);
        assertTrue(s.contains(1));
        assertEquals(1, s.length());
    }

    @Test
    void add_edge_duplicateIgnored() {
        IntegerSet s = new IntegerSet();
        s.add(5);
        s.add(5);
        assertEquals(1, s.length());
        assertEquals("[5]", s.toString());
    }

    @Test
    void remove_normal_removesExisting() {
        IntegerSet s = new IntegerSet();
        s.add(1);
        s.add(2);
        s.remove(2);
        assertFalse(s.contains(2));
        assertEquals("[1]", s.toString());
    }

    @Test
    void remove_edge_valueNotPresent_noChange() {
        IntegerSet s = new IntegerSet();
        s.add(1);
        s.remove(99);
        assertEquals(1, s.length());
        assertTrue(s.contains(1));
    }

    @Test
    void union_normal_combinesSets() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(3);
        IntegerSet u = a.union(b);
        assertEquals("[1, 2, 3]", u.toString());
        assertEquals("[1, 2]", a.toString());
        assertEquals("[2, 3]", b.toString());
    }

    @Test
    void union_edge_withEmptySet() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        IntegerSet empty = new IntegerSet();
        IntegerSet u = a.union(empty);
        assertEquals("[1, 2]", u.toString());
        assertTrue(empty.isEmpty());
    }

    @Test
    void intersect_normal_commonElements() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        a.add(3);
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(3);
        b.add(4);
        IntegerSet i = a.intersect(b);
        assertEquals("[2, 3]", i.toString());
    }

    @Test
    void intersect_edge_noCommonElements() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        IntegerSet b = new IntegerSet();
        b.add(2);
        assertEquals("[]", a.intersect(b).toString());
    }

    @Test
    void diff_normal_elementsOnlyInFirst() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        a.add(3);
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(3);
        b.add(4);
        assertEquals("[1]", a.diff(b).toString());
    }

    @Test
    void diff_edge_identicalSets() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(1);
        assertEquals("[]", a.diff(b).toString());
    }

    @Test
    void complement_normal_elementsInSecondNotInFirst() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        a.add(3);
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(3);
        b.add(4);
        assertEquals("[4]", a.complement(b).toString());
    }

    @Test
    void complement_edge_disjointSets() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        IntegerSet b = new IntegerSet();
        b.add(3);
        b.add(4);
        assertEquals("[3, 4]", a.complement(b).toString());
    }

    @Test
    void isEmpty_edge_newSetIsEmpty() {
        assertTrue(new IntegerSet().isEmpty());
    }

    @Test
    void isEmpty_normal_nonEmptyAfterAdd() {
        IntegerSet s = new IntegerSet();
        s.add(0);
        assertFalse(s.isEmpty());
    }

    @Test
    void toString_normal_sortedBracketFormat() {
        IntegerSet s = new IntegerSet();
        s.add(3);
        s.add(1);
        s.add(2);
        assertEquals("[1, 2, 3]", s.toString());
    }

    @Test
    void toString_edge_emptySet() {
        assertEquals("[]", new IntegerSet().toString());
    }
}
