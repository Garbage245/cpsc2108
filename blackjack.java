
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
        private static String[] base = {
            "A", "A", "A", "A", "2", "2", "2", "2", "3", "3", "3", "3", "4", "4", "4", "4",
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
    public static class Gambler{
        private int hand = 0;
        private int lives = 3;

        // Performs an action depending on player's input
        // Draw a card from the deck
        // Stand and end player phase
        // Fold and restart the round without losing a life
        // If player hand = 21, player automatically wins
        // If player hand > 21, player busts and loses round
        public void playerAction(String input, Gambler name, ScoreBoard board){
            if (!input.equals("H") && !input.equals("S") && !input.equals("F")){
                System.out.println("Invalid input. Please type H, S. or F.\n");
            }
            else{
                if (input.equals("H")){
                    int current = Deck.draw(name);
                    while (current == 0){
                        current = Deck.draw(name);
                    }
                    name.hand += current;
                    if (name.hand > 21 || name.hand == 21){
                        board.playerPhase = false;
                    }
                    }
                else if (input.equals("S")){
                    board.playerPhase = false;
                }
                else if (input.equals("F")){
                    board.roundStart(board.player, board.dealer);
                }
            }
            System.out.println("-----------------------------------------");
        }

        // Dealer draws cards until hand > 17
        public void dealerAction(Gambler name){
            while (name.hand < 17){
                int current = Deck.draw(name);
                while (current == 0){
                    current = Deck.draw(name);
                }
                name.hand += current;
            }
        }
    }


    // Uses Gambler objects to create a score display for player and dealer
    // Keeps track of phase
    public static class ScoreBoard{
        public boolean playerPhase = true;
        public boolean gameStatus = true;
        public Gambler player;
        public Gambler dealer;
        
        // Instantiates with references to player and dealer objects
        public ScoreBoard(Gambler p, Gambler d){
            player = p;
            dealer = d;
        }

        // Gives player two cards to start
        // Dealer gets 1 card to represent the player only being able to see one of the dealer's cards during their phase
        // If player draws a 10 and an A on round start, they win
        public void roundStart(Gambler p, Gambler d){
            p.hand = 0;
            d.hand = 0;
            Deck.shuffle(Deck.base);
            for (int i = 0; i < 2; i++){
                int currentP = Deck.draw(p);
                while (currentP == 0){
                    currentP = Deck.draw(p);
                }
                p.hand += currentP;
            }
            int currentD = Deck.draw(d);
            while (currentD == 0){
                    currentD = Deck.draw(d);
                }
            d.hand += currentD;
            if (player.hand >= 21){
                playerPhase = false;
            }
            else{
                playerPhase = true;
            }
        
        }

        // Handles results at end of round and ends the game when a life counters hits 0
        public void roundResults(){
            System.out.println(display());
            if (dealer.hand > player.hand && dealer.hand <= 21 || dealer.hand < player.hand && player.hand > 21){
                player.lives -= 1;
                System.out.println("Dealer wins round\nPlayer loses a life" +
                                    "\n-----------------------------------------");
            }
            else if (player.hand > dealer.hand && player.hand <= 21 || player.hand < dealer.hand && dealer.hand > 21){
                dealer.lives -= 1;
                System.out.println("Player wins round\nDealer loses a life" +
                                    "\n-----------------------------------------");
            }
            else if (player.hand == dealer.hand){
                System.out.println("Draw\nNo one loses a life" +
                                    "\n-----------------------------------------");
            }
            if (dealer.lives == 0){
                gameStatus = false;
                System.out.println("Game Won");
            }
            else if (player.lives == 0){
                gameStatus = false;
                System.out.println("Game Over");
            }
        }

        // Creates a display of player and dealer stats
        public String display(){
            String output = "Player\t\t\t\tDealer\n" +
                            "Lives: " + player.lives + "\t\t\t" + "Lives: " + dealer.lives +
                            "\nHand: " + player.hand + " \t\t\t" + "Hand: " + dealer.hand + 
                            "\n-----------------------------------------";
            return output;
        }
    }


  

    public static void main(String[] args){
        Scanner helpy = new Scanner(System.in);
        Gambler player = new Gambler();
        Gambler dealer = new Gambler();
        ScoreBoard board = new ScoreBoard(player, dealer);
        while (board.gameStatus){
            board.roundStart(player, dealer);
            while (board.playerPhase){
                System.out.println(board.display());
                System.out.println("Type S to stand\nType H to hit\nType F to fold");
                player.playerAction(helpy.nextLine().toUpperCase(), player, board);
            }
            if (player.hand < 21){
                dealer.dealerAction(dealer);
            }
            board.roundResults();
        }
    }
}

