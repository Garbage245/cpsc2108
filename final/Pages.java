import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
public class Pages{
    ArrayList<Page> pageList;
    Queue<Page> pageOrder = new LinkedList<>();

    public Pages(){
        Page page1 = new Page("");
        Page page2 = new Page("");
        Page page3 = new Page("");
        Page page4 = new Page("");
        Page page5 = new Page("");
        Page page6 = new Page("");
        Page page7 = new Page("");
        Page page8 = new Page("");
        pageList = new ArrayList<>(List.of(page1, page2, page3, page4, page5, page6, page7, page8));
        
        // sort list
        // add items from list to queue
    }

    public String getMessage(){
        // pageOrder.peek() to add page to inventory
        return "";
    }

    public void sortPages(){
        // sort by modulus? randomly pick a number to mod by, then randomly pick whether to order by ascending or descending
        // modulus division length of page

    }

    private class Page{
        String message;

        private Page(String input){
            message = input;
        }
    }



    // getMessage() # takes message from queue, then adds it to the inventory
}
