package edu.trinity;
import java.util.*;

public class MyStack<T> {
    private List<T> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    public void push(T item) {
        data.add(item);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data.get(data.size() -1);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int lastIndex = data.size() - 1;
        T poppedData =  data.get(lastIndex);
        data.remove(lastIndex);
        return poppedData;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
