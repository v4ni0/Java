package bg.sofia.uni.fmi.mjt.gameplatform.store.item.category;

import bg.sofia.uni.fmi.mjt.gameplatform.store.item.StoreItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Game implements StoreItem
{
    private String title;
    private String genre;
    private BigDecimal price;
    private LocalDateTime releaseDate;
    private int numberOfRatings;
    private double averageRating;

    public Game(String title, BigDecimal price, LocalDateTime releaseDate,String genre)
    {
        setTitle(title);
        setPrice(price);
        setReleaseDate(releaseDate);
        setGenre(genre);
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
    public double getRating()
    {
        return averageRating;
    }
    public String getGenre()
    {
        return genre;
    }
    @Override
    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    @Override
    public void setTitle(String title)
    {
        this.title=title;

    }

    @Override
    public void setPrice(BigDecimal price)
    {
        this.price=price;

    }

    @Override
    public void setReleaseDate(LocalDateTime releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    @Override
    public void rate(double rating)
    {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        double totalRating = this.averageRating * this.numberOfRatings;
        totalRating += rating;
        this.numberOfRatings++;
        this.averageRating = totalRating / this.numberOfRatings;
    }
    public void setGenre(String genre)
    {
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", numberOfRatings=" + numberOfRatings +
                ", averageRating=" + averageRating +
                '}';
    }
}
