package JavaOOP.UnitTesting.Exercise.test.java.p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {5, 8, 20, 64, 98};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        this.database  = new Database(NUMBERS);
    }


    // Constructor test
    @Test
    public void testConstructorShouldCreateValidObject(){
        Integer[] databaseElements = database.getElements();
        assertEquals("Count of elements are not equal!",
                NUMBERS.length, databaseElements.length);
        for (int i = 0; i < databaseElements.length; i++) {
            assertEquals(NUMBERS[i], databaseElements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    // Add method test
    @Test (expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenElementIsNull() throws OperationNotSupportedException {
        database.add(null);
    }
    // 1.If element is null
    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        database.add(7);
        assertEquals(6, database.getElements().length);
        assertEquals(Integer.valueOf(7), database.getElements()[database.getElements().length - 1]);
    }
    // 2.If element is correct -> successful add


    // Remove method test
    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWithEmptyData() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();

    }

    // 1. If our collection is empty
    @Test
    public void testRemoveShouldRemoveTheLastElement() throws OperationNotSupportedException {
        database.remove();
        assertEquals(NUMBERS.length - 1, database.getElements().length);
        assertEquals(Integer.valueOf(64), database.getElements()[database.getElements().length -1]);
    }
    // 2. Successful remove

}