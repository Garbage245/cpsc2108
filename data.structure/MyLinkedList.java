public class MyLinkedList<E> implements MyListInterface<E>{
    private Node<E> head;
    private Node<E> tail;
    private int length;

    public MyLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    public boolean add(E element){
        if (head == null){
            Node<E> node = new Node<>(element);
            this.head = node;
            this.tail = node;
            length++;
            return true;
        }
        else{
            // Node<E> currentNode = head;
            
            // while (currentNode.next != null){
            //     currentNode = currentNode.next;
            // }
            
            Node<E> node = new Node<>(element);
            // currentNode.next = node;
            node.previous = tail;
            tail.next = node;
            tail = node;
            length++;
            return true;
        }
    }


    public int indexOf(Object o){
        Node<E> currentNode = head;
        int index = 0;

        while (currentNode != null){
            if (currentNode.data.equals(o)){
                return index;
            }
            else{
                index++;
                currentNode = currentNode.next;
            }
        }

        return -1;
    }

    public int lastIndexOf(Object o){
        Node<E> currentNode = tail;
        int index = size();
        while (currentNode != null){
            if (currentNode.data.equals(o)){
                return index;
            }
            else{
                index--;
                currentNode = currentNode.previous;
            }
        }

        return -1;
    }

    public E remove(int index){
        E returnVal;
        if (index == 0){
            if (head != null){
                returnVal = head.data;
                head = head.next;
                head.previous.next = null;
                head.previous = null;
                length--;
                return returnVal;
            }
        }
        else if (index == size()-1){
                returnVal = tail.data;
                tail = tail.previous;
                tail.next.previous = null;
                tail.next = null;
                length--;
                return returnVal;
        }
        else if (index > 0 && index < size()-1){
            Node<E> currentNode = head;
            for (int i = 0; i < index-1; i++){
                currentNode = currentNode.next;
            }
            returnVal = currentNode.next.data;
            currentNode.next = currentNode.next.next;
            currentNode.next.previous = currentNode.next.previous.previous;
            length--;
            return returnVal;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    public int size(){
        return length;
    }
    
    private class Node<E>{
        E data;
        Node<E> next;
        Node<E> previous;

        Node(E data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
    
}