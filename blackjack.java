import java.util.Scanner;
public class blackjack{
    //Things to do
    // 1) make a deck object that contains 52 cards (array)
    // 2) some type of user input (ask user if they want to hit, stand, or fold)
    // 3) add chips to dealer and player so there's a way to win. (maybe give player an option to set amount)
    // 4) prompt player to put set an amount of chips in pot. dealer copies player value
    // 5) code ace to function as a 1 or 11. 11 when hand is <22 and 1 when total is >22
    // 6) code dealer to draw cards after player stands. dealer stops drawing when hand >17 or dealer busts
    // 7) make a display to show chip counter, player hand, dealer hand, and total pot
    // 8) when player or dealer wins add pot to winner's chip counter and remove amount from loser's
    // 9) game over/won screen
    // 10) code suits if i feel like it
    
    // Standard deck of playing cards using a String array of card values
    public class Deck{
        private static String[] reset = {"A", "A", "A", "A", "2", "2", "2", "2", "3", "3", "3", "3", "4", "4", "4", "4",
                                    "5", "5", "5", "5", "6", "6", "6", "6", "7", "7", "7", "7", "8", "8", "8", "8",
                                    "9", "9", "9", "9", "10", "10", "10", "10", "J", "J", "J", "J", "Q", "Q", "Q", "Q",
                                    "K", "K", "K", "K"};
        private static String[] cards = new String[52];
        
        public static int draw(){
            int number = (int)Math.random()*(52);
            if (cards[number].equals("J") || cards[number].equals("Q") || cards[number].equals("K")){
                cards[number] = null;
                return 10;
            }
            else if (cards[number].equals("A")){
                if (PlayerStats.hand + 11 > 21 || DealerStats.hand > 21){
                    cards[number] = null;
                    return 1;
                }
                else{
                    cards[number] = null;
                    return 11;
                }
            }
            else{
                int cardValue =  Integer.parseInt(cards[number]);
                cards[number] = null;
                return cardValue;
            }
        }

        public static void shuffle(){
            cards = reset;
            String[] shuffledDeck = new String[52];
            for (int i = 0; i < cards.length; i++){
                int number = (int)Math.random()*(52);
                if (shuffledDeck[number] == null){
                    shuffledDeck[number] = cards[i];
                }
                else{
                    i--;
                }
            }
        }
    }

    //Stats for player and dealer 
    public class PlayerStats{
        private static int hand;
        private static int chips;
    }

    public class DealerStats{
        private static int hand;
        private static int chips;
    }

    // Uses Player and Dealer stat objects to create a score display
    public class ScoreBoard{
        public ScoreBoard(PlayerStats player, DealerStats dealer){

        }
    }

    public void action(String input){}

    public static void main(String[] args){
        Scanner helpy = new Scanner(System.in);
        // Deck.shuffle();
        System.out.println("Shuffle complete");
    }
}