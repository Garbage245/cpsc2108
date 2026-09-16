import java.util.Arrays;
public class MyArrayList<E> implements MyListInterface<E>{
    private E[] data;
    
    public void myArrayList(){
        data = (E[]) new Object[0];
    }


    public void add(int index, E element){
        // check if index is valid
        if (index > size()){
            throw new IndexOutOfBoundsException();
        }

        // resize
        data = Arrays.copyOf(data, data.length+1);

        // shift elements
        for (int i = data.length-1; i > index; i--){
            data[i] = data[i-1];
        }

        data[index] = element;
    }

    public boolean add(E element){
        //1. resize the array
        data = Arrays.copyOf(data, data.length+1);
        //2. add or import the data
        data[data.length-1] = element;
        return true;
    }
    
    public boolean contains(Object o){
        for (int i = 0; i < size(); i++){
            if (data[i].equals(o)){
                return true;
            }
        }

        return false;
    }

    public E get(int index){
        return data[index];
    }

    public int lastIndexOf(Object o){
        int index = -1;
        for (int i = size()-1; i >= 0; i--){
            if (data[i].equals(o)){
                index = i;
            }
        }
        return index;
    }

    public int indexOf(Object o){
        for (int i = 0; i < size(); i++){
            if (data[i].equals(o)){
                return i;
            }
        }

        return -1;
    }

    public E remove(int index){
        // check index
        if (index > size()-1 || index < 0){
            throw new IndexOutOfBoundsException();
        }

        // ssave the value
        E value = data[index];

        // shift the elements
        for (int i = index; i < size(); i++){
            data[i] = data[i+1];
        }

        // resize
        data = Arrays.copyOf(data, data.length-1);
        return value;
    }

    public boolean remove(Object o){
        int index = indexOf(o);
        if(index == -1){
            return false;
        }
        else{
            remove(index);
            return true;
        }
    }

    public E set(int index, E element){
        // check index
        if (index > size() || index < 0){
            throw new IndexOutOfBoundsException();
        }

        // store previous data
        E previous = data[index];

        // insert new data
        data[index] = element;

        // return old data
        return previous;
    }

    public int size(){
        return data.length;
    }
}