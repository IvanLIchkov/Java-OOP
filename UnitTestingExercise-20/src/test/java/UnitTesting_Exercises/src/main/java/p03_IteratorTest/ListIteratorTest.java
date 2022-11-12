package UnitTesting_Exercises.src.main.java.p03_IteratorTest;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.security.PublicKey;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private ListIterator listIterator;
    private final String[] ELEMENTS = {"Angel", "Mariya", "Deya", "Emanuil"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator= new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNull() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }


    @Test
    public void testHasNext(){
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
        listIterator.move();
    }

    @Test
    public void testMoveMethod(){
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintWithEmptyIterator() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintElementFromListIterator(){
        for (int i = 0; i <ELEMENTS.length ; i++) {
            assertEquals(ELEMENTS[i], listIterator.print());
            listIterator.move();
        }
    }
}