package bg.sofia.uni.fmi.mjt.gameplatform.store.item.category;

import bg.sofia.uni.fmi.mjt.gameplatform.store.item.StoreItem;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameBundle implements StoreItem {
    private String title;
    private BigDecimal price;
    private LocalDateTime releaseDate;
    private Game[] games;
    private int numberOfRatings;
    private double averageRating;

    public GameBundle(String title, BigDecimal price, LocalDateTime releaseDate, Game[] games) {
        this.title = title;
        this.price = price;
        this.releaseDate = releaseDate;
        this.games = games;
        this.numberOfRatings=0;
        this.averageRating = 0;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public double getRating() {
        return averageRating;
    }

    @Override
    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public void rate(double rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        averageRating = (averageRating * numberOfRatings + rating) / (++numberOfRatings);
    }

    public Game[] getGames() {
        return games;
    }

    public void addGame(Game game)
    {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        List<Game> gameList = new ArrayList<>(Arrays.asList(games));
        gameList.add(game);
        games = gameList.toArray(new Game[0]);
    }
    @Override
    public String toString() {
        return "GameBundle{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", games=" + Arrays.toString(Arrays.stream(games).map(Game::toString).toArray(String[]::new)) +
                ", averageRating=" + averageRating +
                '}';
    }
}