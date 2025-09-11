package _04_DesignPatterns.Behavioral.Iterator.good;

public interface IIterator<T> {

    void next();

    boolean hasNext();

    T current();
}
