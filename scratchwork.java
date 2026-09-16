public class scratchwork{
    public static void main(String[] args) {
        String[] base = {
            "A", "A", "A", "A", "2", "2", "2", "2", "3", "3", "3", "3", "4", "4", "4", "4",
            "5", "5", "5", "5", "6", "6", "6", "6", "7","7", "7", "7", "8", "8", "8", "8",
             "9", "9", "9", "9", "10", "10", "10", "10", "J", "J", "J", "J", "Q", "Q", "Q", "Q",
             "K", "K", "K", "K", "A", "A", "A", "A", "2", "2", "2", "2", "3", "3", "3", "3", "4", "4", "4", "4",
            "5", "5", "5", "5", "6", "6", "6", "6", "7","7", "7", "7", "8", "8", "8", "8",
             "9", "9", "9", "9", "10", "10", "10", "10", "J", "J", "J", "J", "Q", "Q", "Q", "Q",
             "K", "K", "K", "K"};
        String[] cards = new String[104];

        long start = System.nanoTime();
        int backHalf = 103;
        int frontHalf = 0;
        int num;
        String[] newDeck = new String[104];
        for (String card : base){
            num = (int) (Math.random() * 10000);
            if (num % 6 == 0 || num % 7 == 0 || num % 8 == 0 || num % 9 == 0){
                newDeck[frontHalf] = card;
                frontHalf += 1;
            }
            else if (num % 1 == 0|| num % 2 == 0 || num % 3 == 0 || num % 4 == 0 || num % 5 == 0){
                newDeck[backHalf] = card;
                backHalf -= 1;
            }
        }
        cards = newDeck;
        long end = System.nanoTime();
        System.out.println("Total time: " + (end - start));
    }
}