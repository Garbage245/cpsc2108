public class Main {
    public static void main(String[] args) {

        // ---- Sample data to load into the Purchase Log ----
        PurchaseItem[] sampleItems = {
            new PurchaseItem("Bread", 3.49),
            new PurchaseItem("Milk", 2.99),
            new PurchaseItem("Eggs", 4.29),
            new PurchaseItem("Coffee", 8.99),
            new PurchaseItem("Bananas", 1.29),
            new PurchaseItem("Cereal", 4.79),
            new PurchaseItem("Chicken Breast", 9.99),
            new PurchaseItem("Paper Towels", 6.49)
        };

        PurchaseLog log = new PurchaseLog();

        // TODO: write a loop that adds every item in sampleItems to log using addItem().
        for (PurchaseItem item : sampleItems){
            log.addItem(item);
        }

        System.out.println("Purchase Log loaded with " + log.itemCount() + " items.");

        // Example test call — findItemByName. Do the same for every other required method.
        PurchaseItem found = log.findItemByName("Coffee");
        System.out.println("Looked up 'Coffee', found: " +
            (found != null ? found.getName() + " $" + found.getPrice() : "NOT FOUND"));

        // TODO: test printDailyReport() — call it and confirm the totals look correct against sampleItems.
        log.printDailyReport();



        // ---- Sample data to load into the Checkout Line ----
        Customer[] sampleCustomers = {
            new Customer("Alvarez", 12),
            new Customer("Chen", 3),
            new Customer("Patel", 27),
            new Customer("O'Brien", 1)
        };

        CheckoutLine line = new CheckoutLine();

        // TODO: write a loop that adds every customer in sampleCustomers to line using addToBack().
        for (Customer name : sampleCustomers){
            line.addToBack(name);
        }

        System.out.println("Checkout Line loaded, size = " + line.size());

        // Example test call — addToFront (O'Brien has 1 item, gets waved to the front).
        Customer express = new Customer("Nguyen", 1);
        System.out.println("Waving " + express.getName() + " to the front...");
        line.addToFront(express);


        // System.out.println();
        //  // Purchase Log
        // long logStart;
        // long logEnd;
        // long logTotal;
        // logStart = System.nanoTime();
        // System.out.println("Purchase Log time comparison");
        // for (int i = 0; i < 1000; i++){
        //     log.findItemByName("Chicken Breast");
        // }
        // logEnd = System.nanoTime();
        // logTotal = logEnd - logStart;
        // System.out.println("Total Purchase Log Time: " + logTotal);

        // // Checkout Line
        // long lineStart;
        // long lineEnd;
        // long lineTotal;
        // System.out.println("Checkout Line time comparison");
        // lineStart = System.nanoTime();
        // for (int i = 0; i < 1000; i++){
        //     line.addToFront(express);
        // }
        // lineEnd = System.nanoTime();
        // lineTotal = lineEnd - lineStart;
        // System.out.println("Total Checkout Line Time: " + lineTotal);
    }
}