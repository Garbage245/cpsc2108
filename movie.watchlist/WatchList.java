import java.util.List;
import java.util.ArrayList;
public class WatchList implements WatchListInterface{
    private List<String> data;

    public WatchList(){
        data = new ArrayList<String>();
    }

    public void addMovie(String title){
        data.add(title);
    }

    public boolean removeMovie(String title){
        return data.remove(title);
    }

    public void updateMovie(int index, String newTitle){
        data.set(index, newTitle);
    }

    public String getMovie(int index){
        return data.get(index);

    }

    public int getSize(){
        return data.size();
    }

    public void printWatchlist(){
        for (int i = 0; i < getSize(); i++){
            System.out.println(i+1 + ")" + data.get(i));
        }
    }
}