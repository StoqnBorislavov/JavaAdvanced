package JavaOOP.UnitTesting.Exercise.test.java.p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    @Test
    public void testBubbleSort() {
        int[] numbers = {3, 44, 37, 5, 47, 15};
        Bubble.sort(numbers);
        int[] expectedSortedArray = {3, 5, 15, 37, 44, 47};
        Assert.assertEquals(expectedSortedArray.length, numbers.length);
        Assert.assertArrayEquals(expectedSortedArray, numbers);
    }

}