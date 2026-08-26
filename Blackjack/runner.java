public class runner{
    public static void main(String[] args){
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