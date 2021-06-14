package Generics.Exercise.CustomList_07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> elements;

    public CustomList(){
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        this.elements.add(element);
    }

    public T remove(int index){
        return this.elements.remove(index);
    }

    public boolean contains(T element){
        return this.elements.contains(element);
    }

    public void swap(int index1, int index2){
        T element1 = this.elements.get(index1);
        this.elements.set(index1, this.elements.get(index2));
        this.elements.set(index2, element1);
    }

    public int countGreaterThan(T element){
        int counter = 0;
        for (T elementFromData : elements) {
            if(elementFromData.compareTo(element) >= 1){
                counter++;
            }
        }
        return counter;
    }

    public T getMax(){
        return this.elements.stream().max((a, b) -> a.compareTo(b)).get();
    }

    public T getMin(){
        return this.elements.stream().min(Comparable::compareTo).get();
    }

    public List<T> getElements() {
        return elements;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public T next() {
                return elements.get(index++);
            }
        };
    }
}
