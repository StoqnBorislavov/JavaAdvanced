package Generics.Exercise.GenericBox_01;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {

    private final List<T> storedData;

    public Box() {
        this.storedData = new ArrayList<>();
    }

    public int countOfBiggerElements(T element){
        int counter = 0;
        for (T elementFromData : storedData) {
            if(elementFromData.compareTo(element) >= 1){
                counter++;
            }
        }
        return counter;
    }

    public void add(T element){
        this.storedData.add(element);
    }

    public void swapToElements(int firstIndex, int secondIndex){
        T firstElement = this.storedData.get(firstIndex);
        this.storedData.set(firstIndex, this.storedData.get(secondIndex));
        this.storedData.set(secondIndex, firstElement);
    }

    @Override
    public String toString() {
       StringBuilder stringBuilder = new StringBuilder();
        for (T element : storedData) {
            stringBuilder.append(element.getClass().getName())
                    .append(": ")
                    .append(element)
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
