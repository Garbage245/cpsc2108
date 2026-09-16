public interface MyListInterface<E>{
    void add(int index, E element);
    boolean add(E element);
    boolean contains(Object o);
    int lastIndexOf(Object o);
    int indexOf(Object o);
    E get(int index);
    E set(int index, E element);
    int size();
    
}