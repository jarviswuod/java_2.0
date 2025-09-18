package _04_DesignPatterns.Behavioral.Iterator.good;

public interface Iterator<T> {

    void next();

    boolean hasNext();

    T current();
}
