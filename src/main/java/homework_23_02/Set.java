package homework_23_02;

import java.util.Arrays;

public class Set<T> implements ISet<T> {
    private Object[] set; //массив stack - очередь
    private int size;//количество элементов
    public Set() {
        set = new Object[10];
        size = 0;
    }

    public T check(T e) throws RepeatElementException {
        for (int i = 0; i < size ; i++) {
            if (set[i] == e) throw new RepeatElementException();
        }
        return e;
    }

    public void add(T e) throws RepeatElementException {
        if (size == 0) { //если массив пустой
            set[0] = e;
        }
        if (size == set.length + 1) { //если надо расширить массив
            Object[] temp = new Object[set.length * 3];
            System.arraycopy(set, 0, temp, 0, set.length);
            set = temp;
        }
        if (check(e) != null) {
            set[size++] =  e;
        }
    }

    public boolean contains(Object e) {
        for (int i = 0; i < size; i++) {
            if(set[i].equals(e)) return true;
        }
        return false;
    }

    public void delete(int index) {
        if(index >= set.length) throw new IndexOutOfBoundsException();
        Object[] arr = new Object[set.length - 1];
        System.arraycopy(set, 0, arr, 0, index);
        if (arr.length - index >= 0) System.arraycopy(set, index + 1, arr, index, arr.length - index);
        set = arr;
        size--;
    }

    public Object[] asList() {
        return set;
    }

    public String toString() {
        return Arrays.toString(set);
    }

}
