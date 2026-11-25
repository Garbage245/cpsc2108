import java.util.Map;
import java.util.HashMap;
public class scratchwork{
    public static void main(String[] args) {
        Map<String, Integer> counts = new HashMap<>();
        String[] words = {"to", "be", "or", "not", "to", "be"}; 
        for (String currentWord : words){
            if (!counts.containsKey(currentWord)){
                for (String word : words){
                    if (currentWord.equals(word)){
                        counts.put(currentWord, counts.getOrDefault(currentWord, 0) + 1); 
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}


// inventory.put(currentWord, inventory.getOrDefault(currentWord, 0) + 1); 