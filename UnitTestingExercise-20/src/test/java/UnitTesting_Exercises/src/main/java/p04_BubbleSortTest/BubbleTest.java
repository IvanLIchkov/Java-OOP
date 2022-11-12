package UnitTesting_Exercises.src.main.java.p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testSort(){
        int[] numbers= {9, -5, 6, 1 ,12 ,100};
        Bubble.sort(numbers);
        int[] sortedArray={-5, 1, 6, 9, 12, 100};
        Assert.assertArrayEquals(sortedArray,numbers);
    }

}