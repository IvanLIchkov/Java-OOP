package UnitTesting_Exercises.src.main.java.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {5 , 8 , 21 , 68 ,81 , -5};

    @Before
    public void prepare() throws OperationNotSupportedException {
        Integer[] numbers=NUMBERS;
        database = new Database(numbers);
    }

    @Test
    public void testCreateDatabase() throws OperationNotSupportedException {
        Integer[] dbElements= database.getElements();
        Assert.assertEquals(database.getElements().length ,dbElements.length );

            Assert.assertArrayEquals(database.getElements(),dbElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithLessThanOneArgument() throws OperationNotSupportedException {
         new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreThanAllowedArgument() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        Database database = new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddWithElementIsEqualToNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddMethod() throws OperationNotSupportedException{
        int initialSize=database.getElements().length;
        database.add(1);
        Integer[] elements = database.getElements();
        int lastNumber=elements[elements.length-1];
        Assert.assertEquals(1 ,lastNumber);
        Assert.assertEquals(initialSize+1,database.getElements().length);
    }

    @Test
    public void testRemoveMethod() throws OperationNotSupportedException {
        int initialSize=database.getElements().length;
        database.remove();
        Integer[] elements = database.getElements();

        Assert.assertEquals(initialSize-1,database.getElements().length);

        int secondToLastBeforeDelete = NUMBERS[NUMBERS.length-2];
        int lastElementAfterDelete = elements[elements.length-1];

        Assert.assertEquals(secondToLastBeforeDelete,lastElementAfterDelete );
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodIfItGoesOutOfBounds() throws OperationNotSupportedException {
        for (int i = 0; i <NUMBERS.length ; i++) {
            database.remove();
        }
        database.remove();
    }
}