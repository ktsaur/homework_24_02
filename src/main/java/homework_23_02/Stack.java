package homework_23_02;

import homework_23_02.EmptyElException;
import homework_23_02.IStack;

import java.util.Arrays;

public class Stack<T> implements IStack<T> {
    private Object[] stack; //массив stack - очередь
    private int size;//количество элементов

    public Stack() {
        stack = new Object[10];
        size = 0;
    }

    public T pop() {
        if (size == 0) throw new IndexOutOfBoundsException();
        Object obj = stack[size - 1];
        Object[] stack2 = new Object[size - 1];
        System.arraycopy(stack, 0, stack2, 0, size - 1);
        stack = stack2;
        size--;
        return (T) obj;
    }


    public void push(T e) throws EmptyElException {
        if (e == null) {
            throw new EmptyElException();
        }
        if (size == stack.length) {
            Object[] stack2 = new Object[size * 2];
            System.arraycopy(stack, 0, stack2, 0, stack2.length);
            stack = stack2;
        }
        stack[size++] = e;
        size++;
    }
    public String toString() {
        return Arrays.toString(stack);
    }

    public int size() {
        return size;
    }
}
