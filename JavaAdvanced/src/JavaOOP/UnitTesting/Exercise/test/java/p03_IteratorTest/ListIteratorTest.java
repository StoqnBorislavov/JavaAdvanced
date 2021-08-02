package JavaOOP.UnitTesting.Exercise.test.java.p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] DATA = {"Desi", "Ivo", "Iliyan", "Vladislav"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(DATA);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorWithNullParam() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNext(){
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }
    @Test
    public void testMoveMethod(){
        //"Desi", "Ivo", "Iliyan", "Vladislav"
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());

    }

    @Test (expected = IllegalStateException.class)
    public void testPrintEmptyData() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintOnCurrentElement(){
        int index = 0;
        while (listIterator.hasNext()) {
            assertEquals(DATA[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }


}