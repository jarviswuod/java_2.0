import java.util.Iterator;

public class _02_Iteration {

    public static void main(String[] args) {

        GenericClass<String> names = new GenericClass<>();
        names.add("Jarvis");
        names.add("Becky");
        names.add("Felix");
        names.add("Wuod");

        GenericClass<Integer> ages = new GenericClass<>();
        ages.add(10);
        ages.add(90);
        ages.add(20);
        ages.add(50);

        for (Iterator<String> iterator = names.iterator(); iterator.hasNext();) {
            System.out.print(iterator.next() + ",  ");
        }
        System.out.println();

        for (String name : names) {
            System.out.print(name + ",   ");
        }
        System.out.println();

    }
}

class GenericClass<T> implements Iterable<T> {
    private T[] list;
    private int size;

    public GenericClass() {
        size = 0;
        list = (T[]) new Object[100];
    }

    public void add(T value) {
        list[size++] = value;
    }

    public T get(int index) {
        return list[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new OurGenericClass(this);
    }

    private class OurGenericClass implements Iterator<T> {
        private int index = 0;
        private GenericClass<T> list;

        public OurGenericClass(GenericClass<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return list.size > index;
        }

        @Override
        public T next() {
            return list.get(index++);
        }
    }
}