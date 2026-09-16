public class Main{
    public static void main(String[] args) {
        WatchList watchlist = new WatchList();
        watchlist.addMovie("The Matrix");
        watchlist.addMovie("Spirited Away");
        watchlist.addMovie("Blade Runner");
        watchlist.printWatchlist();
        watchlist.updateMovie(1, "Spirited Away (1997)");
        boolean removed = watchlist.removeMovie("The Matrix");
        System.out.println("Removed The Matrix? " + removed);
        watchlist.printWatchlist();
    }
}