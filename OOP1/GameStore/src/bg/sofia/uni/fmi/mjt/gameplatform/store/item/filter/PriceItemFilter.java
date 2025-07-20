package bg.sofia.uni.fmi.mjt.gameplatform.store.item.filter;

import bg.sofia.uni.fmi.mjt.gameplatform.store.item.StoreItem;

import java.math.BigDecimal;

public class PriceItemFilter implements ItemFilter
{
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;
    public PriceItemFilter(BigDecimal minPrice, BigDecimal maxPrice)
    {
        if (minPrice==null || maxPrice == null)
        {
            throw new IllegalArgumentException("Price cannot be null");
        }
        if (minPrice.compareTo(BigDecimal.ZERO) < 0 || maxPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.minPrice=minPrice;
        this.maxPrice=maxPrice;


    }


    @Override
    public boolean matches(StoreItem item)
    {
        return minPrice.compareTo(item.getPrice())<=0 && maxPrice.compareTo(item.getPrice())>=0;
    }
}
