import java.util.NoSuchElementException;

public class MyLinkedStack<E>{
    private Node<E> top;
    private int size;

    public MyLinkedStack(){
        top = null;
        size = 1;
    }

        public void push(E element){
            if(top == null){
                top = new Node<E>(element);
                new Node.next = top
            }
        }

        public E peek(){
            if (top == null){
                throw new NoSuchElementException();
            }
            else{
                return top.data;
            }
        }

        public E pop(){
            //
        }

    private class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }
}