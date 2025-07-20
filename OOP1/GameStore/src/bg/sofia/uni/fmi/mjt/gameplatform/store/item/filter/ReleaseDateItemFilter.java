package bg.sofia.uni.fmi.mjt.gameplatform.store.item.filter;

import bg.sofia.uni.fmi.mjt.gameplatform.store.item.StoreItem;

import java.time.LocalDateTime;

public class ReleaseDateItemFilter implements ItemFilter
{
    private final LocalDateTime lower;
    private final LocalDateTime upper;

    public ReleaseDateItemFilter(LocalDateTime lower, LocalDateTime upper)
    {
        if (lower == null || upper == null) {
            throw new IllegalArgumentException("Release date cannot be null");
        }
        if (lower.isAfter(upper)) {
            throw new IllegalArgumentException("Lower release date cannot be after upper release date");
        }
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public boolean matches(StoreItem item) {
        return (lower.isBefore(item.getReleaseDate()) || lower.isEqual(item.getReleaseDate()))&& (upper.isAfter(item.getReleaseDate()) || upper.isEqual(item.getReleaseDate()));
    }
}
