/*

    NOTES:
    - 


    public synchronized void add(T value) {

        while(isEmpty) {
            list.add(value);
            notifyAll();
        }
        wait();
    }

    public synchronized void remove() {

        while(isEmpty) {
            list.pop();
            notifyAll();
        }
        wait();
    }

 */

import java.util.Arrays;

public class _06_ProducerConsumerPattern {
    public static void main(String[] args) {

        CustomQueue<Integer> list = new CustomQueue<>(5);
        list.add(23);
        list.add(41);
        list.add(68);
        list.add(52);
        list.add(9);
        list.remove();
        list.add(7);

        System.out.println(list);
    }
}

class CustomQueue<T> {

    T[] queList;
    int index;
    int capacity;

    public CustomQueue(int capacity) {
        this.capacity = capacity;
        queList = (T[]) new Object[this.capacity];
        index = 0;
    }

    public boolean isEmpty() {
        return index <= 0;
    }

    public boolean isFull() {
        return index >= capacity;
    }

    public void add(T value) {

        if (!isFull()) {
            queList[index++] = value;
        } else {
            System.out.println("List is full to add : " + value);
        }
    }

    public T remove() {

        if (!isEmpty()) {
            T random = queList[--index];
            return random;
        }
        return null;
    }

    @Override
    public String toString() {
        return "CustomQueue [queList=" + Arrays.toString(queList) + "]";
    }
}