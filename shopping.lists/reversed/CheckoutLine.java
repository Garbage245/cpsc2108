import java.util.ArrayList;
public class CheckoutLine{

    // TODO: declare the field that stores your Customer records.
    // Decide: ArrayList<Customer> or LinkedList<Customer>?
    ArrayList<Customer> data = new ArrayList<Customer>();
    int lineSize;

    public void addToBack(Customer c) {
    // O(1)
        data.add(c);
        lineSize += 1;
    }

    public void addToFront(Customer c) {
    // O(1)
        data.add(0, c);
    }

    public Customer removeFromFront() {
    // O(1)
        if (data.get(0) != null){
            Customer currentCust = data.get(0);
            data.remove(0);
            return currentCust;
        }
        else{
            return null;
        }
    }

    public Customer removeFromBack() {
    // O(1)
        if (data.get(lineSize - 1) != null){
            Customer currentCust = data.get(lineSize - 1);
            data.remove(lineSize - 1);
            return currentCust;
        }
        else{
            return null;
        }
    }

    public int size() {
    // O(1)
        if (!data.isEmpty()){
            return lineSize;
        }
        else{
            return 0;
        }
    }
}