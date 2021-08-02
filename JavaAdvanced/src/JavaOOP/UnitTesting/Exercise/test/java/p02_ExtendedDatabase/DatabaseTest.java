package JavaOOP.UnitTesting.Exercise.test.java.p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private Person firstDefaultPerson;
    private Person secondDefaultPerson;
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        firstDefaultPerson = new Person(1, "Pesho");
        secondDefaultPerson = new Person(2, "Gosho");
        database = new Database(firstDefaultPerson, secondDefaultPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonWithNullValueShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }


    @Test
    public void testAddPersonShouldAddPersonToTheDatabaseAndIncreaseCount() throws OperationNotSupportedException {
        Person person = new Person(3, "Stoqn");
        database.add(person);
        assertEquals(3, database.getElements().length);
        assertEquals(3, database.getElements()[2].getId());
    }

    @Test
    public void testRemoveShouldRemoveTheLastAddedPerson() throws OperationNotSupportedException {
        Person person = new Person(3, "Stoqn");
        database.add(person);
        database.remove();
        assertEquals(2, database.getElements().length);
        assertEquals(2, database.getElements()[1].getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowIfDatabaseIsEmpty() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUserNameShouldThrowIfNoSuchUserIsPresent() throws OperationNotSupportedException {
        database.findByUsername("Stoqn");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUserNameShouldThrowIfParameterOfUsernameIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFindByUserNameShouldFindTheCorrectPerson() throws OperationNotSupportedException {
        assertEquals(2, database.findByUsername("Gosho").getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUserIdShouldThrowIfNoSuchUserIsPresent() throws OperationNotSupportedException {
        database.findById(10);
    }

    @Test
    public void testFindByUserIdShouldFindTheCorrectPerson() throws OperationNotSupportedException {
        assertEquals("Gosho", database.findById(2).getUsername());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testCreateDatabaseWithMoreThan16PeopleShouldThrow() throws OperationNotSupportedException {
        Database database = new Database();
        setDatabase();
    }

    private void setDatabase() throws OperationNotSupportedException {
        database.add(new Person(4, "test1"));
        database.add(new Person(5, "test2"));
        database.add(new Person(6, "test3"));
        database.add(new Person(7, "test4"));
        database.add(new Person(8, "test5"));
        database.add(new Person(9, "test6"));
        database.add(new Person(10, "test7"));
        database.add(new Person(11, "test8"));
        database.add(new Person(12, "test9"));
        database.add(new Person(13, "test10"));
        database.add(new Person(14, "test11"));
        database.add(new Person(15, "test12"));
        database.add(new Person(16, "test13"));
        database.add(new Person(17, "test14"));

    }
}