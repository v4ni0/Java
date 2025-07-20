import bg.sofia.uni.fmi.mjt.gameplatform.store.GameStore;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.StoreItem;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.category.Game;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.filter.ItemFilter;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.filter.PriceItemFilter;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.filter.RatingItemFilter;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.filter.TitleItemFilter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Create some games
        Game game1 = new Game("Cyberpunk 2077", new BigDecimal("59.99"),
                LocalDateTime.of(2020, 12, 10, 0, 0), "RPG");
        Game game2 = new Game("The Witcher 3", new BigDecimal("29.99"),
                LocalDateTime.of(2015, 5, 19, 0, 0), "RPG");
        Game game3 = new Game("FIFA 23", new BigDecimal("49.99"),
                LocalDateTime.of(2022, 9, 30, 0, 0), "Sports");

        // Create store with games
        StoreItem[] items = {game1, game2, game3};
        GameStore store = new GameStore(items);

        // Apply ratings
        game1.rate(4);
        game1.rate(5);
        game2.rate(5);
        game2.rate(5);
        game3.rate(3);

        // Apply filters
        ItemFilter[] filters = {
                new PriceItemFilter(new BigDecimal("20.00"), new BigDecimal("50.00")),
                new RatingItemFilter(4.0),
                new TitleItemFilter("the", false)
        };

        StoreItem[] filteredItems = store.findItemByFilters(filters);
        System.out.println("Filtered items:");
        for (StoreItem item : filteredItems) {
            System.out.println(item.getTitle() + " - $" + item.getPrice() + " - Rating: " + item.getRating());
        }

        System.out.println("\nBefore discount:");
        for (StoreItem item : items) {
            System.out.println(item.getTitle() + " - $" + item.getPrice());
        }
        // Apply promo code
        store.applyDiscount("100YO");
        System.out.println("\nAfter discount:");
        for (StoreItem item : items) {
            System.out.println(item.getTitle() + " - $" + item.getPrice());
        }
    }
}