package data.structure;
import java.util.Arrays;
public class Lecture{
    public class ArrayList<E> implements MyListInterface<E>{
        private E[] data;
        
        public myArrayList(){
            data = (E[]) new Object[0];
        }

        @Override
        public boolean add(E element){
            //1. resize the array
            data = Arrays.copyOf(data, data.length-1);
            //2. add or import the data
            data[data.length-1] = element;
            return true;
        }
}