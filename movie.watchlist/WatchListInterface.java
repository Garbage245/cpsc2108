/**
 * A contract for managing an ordered list of movie titles.
 * Implementations decide how the titles are actually stored.
 */
public interface WatchListInterface {

    // Add a movie title to the end of the watchlist.
    void addMovie(String title);

    // Remove the first occurrence of a movie by title.
    // Return true if it was removed, false if it wasn't found.
    boolean removeMovie(String title);

    // Replace the movie at the given index with newTitle.
    void updateMovie(int index, String newTitle);

    // Return the movie title at the given index.
    String getMovie(int index);

    // Return how many movies are currently on the watchlist.
    int getSize();

    // Print each movie on its own line, prefixed with its index.
    void printWatchlist();
}