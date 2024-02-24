package homework_23_02;

public interface IStack<T> {
    public T pop();
    public void push(T e) throws EmptyElException;
    public int size();
    public String toString();
}
