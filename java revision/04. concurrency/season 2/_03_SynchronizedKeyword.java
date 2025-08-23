import java.util.Arrays;

public class _03_SynchronizedKeyword {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        // System.out.println(stack.isFull());

        // System.out.println(stack.isEmpty());
        // System.out.println(stack.peek());
        stack.push(55);
        // System.out.println(stack.peek());

        stack.push(66);
        System.out.println(stack.peek());

        stack.push(34);
        System.out.println(stack.peek());

        // stack.push(22);
        // System.out.println(stack.peek());

        // stack.push(80);
        // System.out.println(stack.peek());

        // stack.push(13);
        // System.out.println(stack.peek());

        // stack.push(43);
        // System.out.println(stack.peek());
        System.out.println(stack);

        // System.out.println(stack.isEmpty());
        // System.out.println(stack.isFull());

    }
}

class Stack<T> {
    T[] list;
    int size;

    public Stack() {
        size = 0;
        list = (T[]) new Object[5];
    }

    public boolean isEmpty() {
        return size < 1;
    }

    public boolean isFull() {
        return list.length < size;
    }

    public void push(T value) {
        if (!isFull()) {
            list[size++] = value;
        } else
            System.out.println("Is full; cannot add : " + value);

    }

    public T poll() {
        if (isEmpty())
            return list[size--];
        else
            return list[0];
    }

    public T peek() {
        System.out.println(size);
        return list[2];
        // if (!isFull())
        // return list[size - 1];
        // else if (isEmpty())
        // return list[size];
        // else
        // return list[0];

    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}