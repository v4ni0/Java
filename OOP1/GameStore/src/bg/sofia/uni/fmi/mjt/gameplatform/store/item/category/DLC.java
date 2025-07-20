package bg.sofia.uni.fmi.mjt.gameplatform.store.item.category;

import bg.sofia.uni.fmi.mjt.gameplatform.store.item.StoreItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DLC implements StoreItem
{
    private String title;
    private BigDecimal price;
    private LocalDateTime releaseDate;
    private Game game;
    private double averageRating;
    private int numberOfRatings;


    public DLC(String title, BigDecimal price, LocalDateTime releaseDate, Game game)
    {
        setPrice(price);
        setTitle(title);
        setReleaseDate(releaseDate);
        this.game = game;
        this.numberOfRatings = 0;
        this.averageRating = 0.0;
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
        this.title=title;
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
        if (rating < 0 || rating > 5)
        {
            throw new IllegalArgumentException("Rating must be in the range [0, 5]");
        }
        averageRating = (averageRating * numberOfRatings + rating) / (numberOfRatings + 1);
        numberOfRatings++;


    }
}
