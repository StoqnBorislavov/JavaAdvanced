package Generics.Exercise.Tuple_10;

public class Tuple<K, V, E> {
    private K item1;
    private V item2;
    private E item3;

    public Tuple(K item1, V item2, E item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", item1, item2, item3);
    }
}
