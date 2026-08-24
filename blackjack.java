import java.util.Scanner;
public class blackjack{
    //Things to do
    // 1) make a deck object that contains 52 cards (array)
    // 2) some type of user input (ask user if they want to hit, stand, or fold)
    // 3) give player and dealer 3 lives. 1 life is lost when a round is lost
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
            if (cards[number] == null){
                return 0;
            }
            else if (cards[number].equals("J") || cards[number].equals("Q") || cards[number].equals("K")){
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
        private static boolean playerPhase = true;
        private static int hand;
        private static int lives = 3;
    }

    public class DealerStats{
        private static int hand;
        private static int lives = 3;
    }

    // Uses Player and Dealer stat objects to create a score display
    public class ScoreBoard{
        public ScoreBoard(PlayerStats player, DealerStats dealer){

        }
    }

    public static void playerAction(String input){
        if (!input.equals("H") && !input.equals("S")){
            System.out.println("Invalid input. Please type H or S.\n");

        }
        else{
            if (input.equals("H")){
            int current = Deck.draw();
                if (current == 0){
                    current = Deck.draw();
                }
                else{
                    PlayerStats.hand += current;
                    // if player hand > 21 then dealer wins rounds
                }
            }
            else if (input.equals("S")){
            dealerAction();
            }
        }
    }

    public static void dealerAction(){
        while (DealerStats.hand < 17){
            DealerStats.hand += Deck.draw();
            //Print Scoreboard
        }
        // if dealer hand > 21 then player wins round
        
    }
    
    public static void gameStart(){
        // give player and dealer two cards to start
    }

    public static void main(String[] args){
        Scanner helpy = new Scanner(System.in);
        while (PlayerStats.playerPhase){
            //Print ScoreBoard
            System.out.println("Type S to stand\nType H to hit\n");
            playerAction(helpy.nextLine());
        }
        dealerAction();
        
    }
}