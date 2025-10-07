/*

    NOTES:
    - 

 */

import java.util.Iterator;

public class _02_Iteration {
    public static void main(String[] args) {

        GenericClass<String> gClass = new GenericClass<>();
        System.out.println(gClass.size());

        // gClass.remove(148);
        gClass.add("bdn1i2");
        gClass.add("23we");
        gClass.add("3cbf6");
        gClass.add("4qw8");

        System.out.println();

        for (int i = 0; i < gClass.size(); i++) {
            System.out.print(gClass.get(i) + " ");
        }
        System.out.println();

        System.out.println("---");
        for (String string : gClass) {
            System.out.print(string + " ");
        }
        System.out.println();

    }
}

class GenericClass<ObjectType> implements Iterable<ObjectType> {

    public ObjectType[] randomList;
    private int index;

    public GenericClass() {
        setIndex(0);
        randomList = (ObjectType[]) new Object[12];
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void add(ObjectType element) {
        randomList[getIndex()] = element;
        setIndex(getIndex() + 1);
    }

    public ObjectType get(int index) {
        return randomList[index];
    }

    public int size() {
        return getIndex();
    }

    @Override
    public Iterator<ObjectType> iterator() {
        return new InnerGenericClass(this);
    }

    private class InnerGenericClass implements Iterator<ObjectType> {

        GenericClass<ObjectType> _genericClass;
        int innerIndex;
        int size;

        public InnerGenericClass(GenericClass<ObjectType> genericClass) {
            _genericClass = genericClass;
            size = genericClass.index;
            innerIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return size-- > 0;
        }

        @Override
        public ObjectType next() {
            return _genericClass.get(innerIndex++);
        }
    }
}