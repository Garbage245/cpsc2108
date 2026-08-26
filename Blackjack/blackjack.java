
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
        private static String[] base = {"A", "A", "A", "A", "2", "2", "2", "2", "3", "3", "3", "3", "4", "4", "4", "4",
            "5", "5", "5", "5", "6", "6", "6", "6", "7", "7", "7", "7", "8", "8", "8", "8",
            "9", "9", "9", "9", "10", "10", "10", "10", "J", "J", "J", "J", "Q", "Q", "Q", "Q",
            "K", "K", "K", "K"};
        private static String[] cards = new String[52];

        // Generates a random number 0-51 and uses it as an index for the cards array
        // Returns corresponding value of the card and replaces the value in array with null to represent the card being drawn
        // If an ace is drawn, the value added to hand is 11 if hand+11 < 21, otherwise the value added is 1
        public static int draw(Gambler name){
            int number = (int) (Math.random() * 52);
            if (cards[number] == null){
                return 0;
            }
            else if (cards[number].equals("J") || cards[number].equals("Q") || cards[number].equals("K")){
                cards[number] = null;
                return 10;
            }
            else if (cards[number].equals("A")){
                if (name.hand + 11 > 21) {
                    cards[number] = null;
                    return 1;
                } else {
                    cards[number] = null;
                    return 11;
                }
            }
            else{
                int cardValue = Integer.parseInt(cards[number]);
                cards[number] = null;
                return cardValue;
            }
        }

        // Uses the base deck values as input
        // Loops through base deck array to shuffle values into cards array
        // Randomly generates a number between 0-10000 
        // Depending on what number can divide num, a value from base is inserted into the front or back of cards
        public static void shuffle(String[] deck){
            int backHalf = 51;
            int frontHalf = 0;
            int num;
            String[] newDeck = new String[52];
            for (int i = 0; i < deck.length; i++){
                num = (int) (Math.random() * 10000);
                if (num % 6 == 0 || num % 7 == 0 || num % 8 == 0 || num % 9 == 0){
                    newDeck[frontHalf] = deck[i];
                    frontHalf += 1;
                }
                else if (num % 1 == 0|| num % 2 == 0 || num % 3 == 0 || num % 4 == 0 || num % 5 == 0){
                    newDeck[backHalf] = deck[i];
                    backHalf -= 1;
                }
            }
            Deck.cards = newDeck;
        }
    }

    //Stats for player and dealer 
    public class Gambler{
        private int hand = 0;
        private int lives = 3;
    }


    // Uses Gambler objects to create a score display for player and dealer
    // Keeps track of phase
    public class ScoreBoard{
        public boolean playerPhase = true;
        public Gambler player;
        public Gambler dealer;
        
        // Instantiates with references to player and dealer objects
        public ScoreBoard(Gambler p, Gambler d){
            player = p;
            dealer = d;
        }

        // Gives player two cards to start
        // Dealer gets 1 card to represent the player only being able to see one of the dealer's cards during their phase
        public void gameStart(Gambler p, Gambler d){
        Deck.shuffle(Deck.base);
        player.hand = Deck.draw(p) + Deck.draw(p);
        dealer.hand = Deck.draw(d);
        
        }

        // Creates a display of player and dealer stats
        public String display(){
            String output = "Player\t\t\t\tDealer\n" +
                            "Lives: " + player.lives + "\t\t\t" + "Lives: " + dealer.lives +
                            "\nHand: " + player.hand + "\t\t\t" + "Hand: " + dealer.hand;
            return output;
        }
    }


    // Performs an action depending on player's input
    // Draw a card from the deck
    // Stand and end player phase
    // Fold and restart the round without losing a life
    // If player hand = 21, player automatically wins
    public static void playerAction(String input, Gambler name, ScoreBoard board){
        if (!input.equals("H") && !input.equals("S") && !input.equals("F")){
            System.out.println("Invalid input. Please type H, S. or F.\n");
        } else {
            if (input.equals("H")) {
                int current = Deck.draw(name);
                if (current == 0) {
                    current = Deck.draw(name);
                } else {
                    name.hand += current;
                    // if player hand > 21 then dealer wins rounds
                }
            }
            else if (input.equals("S")){
                board.playerPhase = false;
            }
            else if (input.equals("F")){
                board.gameStart(board.player, board.dealer);
                // Start new round
            }
        }
    }

    // Dealer draws cards until hand > 17
    // If hand > 21, player wins round and dealer loses a life
    public void dealerAction(Gambler name){
        while (name.hand < 17){
            name.hand += Deck.draw(name);
        }
    }


    public void main(String[] args){
        Scanner helpy = new Scanner(System.in);
        Gambler player = new Gambler();
        Gambler dealer = new Gambler();
        ScoreBoard board = new ScoreBoard(player, dealer);
        board.gameStart(player, dealer);
        while (board.playerPhase){
            //Print ScoreBoard
            System.out.println("Type S to stand\nType H to hit\nType F to fold");
            playerAction(helpy.nextLine().toUpperCase(), player, board);
        }
        dealerAction(dealer);
        System.out.println(player.hand);
        System.out.println(dealer.hand);
        System.out.println(board.display());
        System.out.println("Complete");
    }
}

