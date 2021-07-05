package JavaAdvanced.Workshop1.SmartArray;

import java.util.function.Consumer;

public class SmartArray<T> {

    private static final int INITIAL_CAPACITY = 4;
    private Object[] elements;
    private int size;

    public SmartArray() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(T element) {
        if (size == elements.length) {
            elements = grow();
        }
        this.elements[size++] = element;
    }

    private Object[] grow() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        return newElements;
    }

    public T get(int index) {
        ensureIndex(index);
        return (T)this.get(index);
    }

    public int size() {
        return this.size;
    }

    public T remove(int index) {
        T element = get(index);

        for (int i = index; i < this.size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--this.size] = 0;

        if (this.size == 0) {
            this.elements = new Object[INITIAL_CAPACITY];
        }

        if (this.size <= elements.length / 4 && elements.length > INITIAL_CAPACITY) {
            this.elements = shrink();
        }

        return element;
    }

    private Object[] shrink() {
        Object[] newElements = new Object[elements.length / 2];
        System.arraycopy(elements, 0, newElements, 0, this.size);
        return newElements;
    }

    private void ensureIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    public boolean contains(int element) {
        for (Object e : elements) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, T element){
        ensureIndex(index);

        T lastElement = get(index);
        for (int i = this.size - 1; i > index; i--) {
            elements[i] = elements[i -1];
        }
        elements[index] = element;
        add(lastElement);
    }

    public void forEach(Consumer<T> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept(get(i));
        }
    }
}
