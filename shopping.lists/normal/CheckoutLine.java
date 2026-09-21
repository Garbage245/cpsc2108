import java.util.LinkedList;
public class CheckoutLine{

    // TODO: declare the field that stores your Customer records.
    // Decide: ArrayList<Customer> or LinkedList<Customer>?
    LinkedList<Customer> data = new LinkedList<Customer>();
    int lineSize;

    public void addToBack(Customer c){
    // adds customer to the back of line
    // O(1)
        data.add(c);
        lineSize += 1;
    }

    public void addToFront(Customer c){
    // adds customer to the front of line
    // O(1)
        data.addFirst(c);
        lineSize += 1;
    }

    public Customer removeFromFront(){
    // checks if data has a head and returns null if so. if data has elements, remove first element and return it
    // O(1)
        if (data.getFirst() != null){
            Customer head = data.getFirst();
            data.remove();
            lineSize -= 1;
            return head;
        }    
        else{
            return null;
        }
    }

    public Customer removeFromBack(){
    // checks if data has a tail and returns null if so. if data has elements, remove last element and return it
    // O(1)
        if (data.getLast() != null){
            Customer tail = data.getLast();
            data.removeLast();
            lineSize -= 1;
            return tail;
        }    
        else{
            return null;
        }
    }

    public int size(){
    // checks if data has no elements and returns 0 if so. returns lineSize if data has elements
    // O(1)
        if (!data.isEmpty()){
            return lineSize;
        }
        else{
            return 0;
        }
    }
}