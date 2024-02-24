package homework_23_02;

public interface ISet<T> {
    void add(T e) throws RepeatElementException;
    T check(T e) throws RepeatElementException;
    Object[] asList();
    void delete(int index);
    boolean contains(Object e);

}
