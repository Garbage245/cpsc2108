import java.util.ArrayList;
public class PurchaseLog{

    // TODO: declare the field that stores your PurchaseItem records.
    // Decide: ArrayList<PurchaseItem> or LinkedList<PurchaseItem>?
    ArrayList<PurchaseItem> data = new ArrayList<PurchaseItem>();
    int count;


    public void addItem(PurchaseItem item){
    // adds item to end of array
    // O(1)
        data.add(item);
        count += 1;

    }

    public PurchaseItem findItemByName(String name){
    // loops through each item and checks if the current item has the same name as input
    // O(n)
        for (int i = 0; i < count; i++){
            PurchaseItem currentItem = data.get(i);
            if (currentItem.getName().equals(name)){
                return currentItem;
            }
        }
        return null;
    }

    public void updatePrice(String name, double newPrice){
    // updates the price of item inputted
    // O(1)
        PurchaseItem currentItem = findItemByName(name);
        if (currentItem != null){
            currentItem.setPrice(newPrice);
        }
    }

    public void printDailyReport(){
    // TODO: loop through every item — total count, total revenue, best seller
    // O(n^2)
        String output = "";
        double revenue = 0;
        String bestSeller = "";
        int currentBestCount = 0;
        int newBestCount = 0;
        
        output += "Total Count: " + count + "\n";

        // loops through every item in data and adds their price
        for (PurchaseItem item : data){
            revenue += item.getPrice();
        }
        output += "Total Revenue: " + revenue + "\n";

        // for each purchase item in data, the progam will loop through the list and count the amount of duplicate names
        for (PurchaseItem item : data){
            for (int i = 0; i < count; i++){
                if (data.get(i).getName().equals(item.getName())){
                    newBestCount += 1;
                }
                if (newBestCount > currentBestCount){
                    bestSeller = item.getName();
                }
            }
        }
        output += "Best Seller: " + bestSeller;
        System.out.println(output);
        
        
    }

    public int itemCount(){
    // checks if data has no elements and returns 0 if so. returns count if data has elements
    // O(1)
        if (!data.isEmpty()){
            return count;
        }
        else{
            return 0;
        }
    }
}