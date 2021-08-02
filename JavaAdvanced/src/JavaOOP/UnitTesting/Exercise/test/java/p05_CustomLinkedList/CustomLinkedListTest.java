package JavaOOP.UnitTesting.Exercise.test.java.p05_CustomLinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIndexShouldThrowIfOutOfBounds() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.get(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIndexShouldThrowIfNegativeIndex() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.get(-1);
    }

    @Test
    public void testGetByIndexShouldReturnTheCorrectElement(){
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(11);
        customLinkedList.add(22);
        customLinkedList.add(33);
        assertEquals(3, customLinkedList.getCount());
        assertEquals(Integer.valueOf(22), customLinkedList.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetOnIndexShouldThrowIfOutOfBounds() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.set(1, 44);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetOnIndexShouldThrowIfNegativeIndex() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.set(-1, 44);
    }
    @Test
    public void testSeOnIndexShouldSetCorrectElementOnTheCorrectIndex(){
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(11);
        customLinkedList.add(22);
        customLinkedList.add(33);
        customLinkedList.set(2, 44);
        assertEquals(Integer.valueOf(44), customLinkedList.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveIndexShouldThrowIfOutOfBounds() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.removeAt(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveIndexShouldThrowIfNegativeIndex() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.removeAt(-1);
    }
    @Test
    public void testShouldRemoveTheCorrectElementOnGivenIndex(){
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(11);
        customLinkedList.add(22);
        customLinkedList.add(33);
        assertEquals(Integer.valueOf(33), customLinkedList.removeAt(2));
    }

    @Test
    public void testRemoveByItemShouldReturnTheCorrectValueIfTheItemIsNotPresent(){
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(11);
        customLinkedList.add(22);
        customLinkedList.add(33);
        assertEquals(-1, customLinkedList.remove(44));
    }
    @Test
    public void testRemoveByItemShouldReturnTheCorrectValue(){
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(11);
        customLinkedList.add(22);
        customLinkedList.add(33);
        assertEquals(0, customLinkedList.remove(11));
    }

    @Test
    public void testIndexOfShouldReturnTheCorrectValueIfTheItemIsNotPresent(){
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(11);
        customLinkedList.add(22);
        customLinkedList.add(33);
        assertEquals(-1, customLinkedList.indexOf(44));
    }
    @Test
    public void testIndexOfShouldReturnTheCorrectIndex(){
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(11);
        customLinkedList.add(22);
        customLinkedList.add(33);
        assertEquals(2, customLinkedList.indexOf(33));
    }

    @Test
    public void testContainsItemShouldReturnTheCorrectValue(){
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(11);
        customLinkedList.add(22);
        customLinkedList.add(33);
        assertTrue(customLinkedList.contains(22));
        assertFalse(customLinkedList.contains(44));
    }

    @Test
    public void testRemoveListNodeWhenNodeIsHeadAndTailAtTheSameTimeShouldReturnEmptyCollection(){
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(11);
        assertEquals(Integer.valueOf(11) ,customLinkedList.removeAt(0));
    }
}