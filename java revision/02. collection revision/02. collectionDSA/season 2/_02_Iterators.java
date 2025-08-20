import java.util.Iterator;

public class _02_Iterators {
    public static void main(String[] args) {
        CustomClass<Integer> intList = new CustomClass<>();
        intList.add(55);
        intList.add(110);
        intList.add(22);
        intList.add(66);

        for (int i = 0; i < intList.size; i++) {
            System.out.print(intList.get(i) + ", ");
        }

        System.out.println();
        for (Integer integer : intList) {
            System.out.print(integer + ", ");
        }

        System.out.println();
    }
}

class CustomClass<T> implements Iterable<T> {
    private T[] items;
    public int size;

    public CustomClass() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public void add(T element) {
        items[size++] = element;
    }

    public T get(int index) {
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new OurIterator(this);
    }

    class OurIterator implements Iterator<T> {

        private CustomClass<T> list;
        private int index = 0;

        public OurIterator(CustomClass<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return list.size > index;
        }

        @Override
        public T next() {
            return list.items[index++];
        }

    }

}