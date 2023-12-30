import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements myList<T> {
    private T[] values;
    private int index;
    private int size;
    private int capasity;

    @SuppressWarnings("unchecked")

    public MyArrayList() {
        this.index = 0;
        this.size = 0;
        this.capasity = 10;
        try {
            this.values = (T[]) new Comparable[capasity];
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    private void addCapasity() {
        T[] temp = (T[]) new Comparable[capasity + capasity / 2];
        System.arraycopy(values, 0, temp, 0, values.length);
        values = temp;
//        try {
//            this.values = (T[]) new Object[capasity];
//        } catch (ClassCastException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void add(T element) {
        if (size == capasity) {
            addCapasity();
        }
        values[size] = element;
        size++;

    }

    @Override
    public void delete(int index) {
        T[] temp = (T[]) new Comparable[capasity-1];
        System.arraycopy(values, 0, temp, 0, index);
        int amountElementsAfterIndex = temp.length - index - 1;
        System.arraycopy(values, index + 1, temp, index, amountElementsAfterIndex);
        values = temp;
        size--;
    }

    @Override
    public void delete(T element) {
        for (int i = 0; i < values.length; i++) {
            T el = values[i];
            if (el.equals(element)) {
                delete(i);
            }
        }

    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return index < values.length;
            }

            @Override
            public T next() {
                return values[index++];
            }
        };
    }
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(values[i]).append(", ");
        }
        if (builder.length() == 1) return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
