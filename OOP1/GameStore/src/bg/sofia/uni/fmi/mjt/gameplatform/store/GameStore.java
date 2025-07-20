package bg.sofia.uni.fmi.mjt.gameplatform.store;

import bg.sofia.uni.fmi.mjt.gameplatform.store.item.StoreItem;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.filter.ItemFilter;


import java.math.BigDecimal;
import java.util.Arrays;
public class GameStore implements StoreAPI
{
    private StoreItem[] availableItems;




    public GameStore(StoreItem[] availableItems)
    {
        this.availableItems=Arrays.copyOf(availableItems, availableItems.length);
    }

    @Override
    public StoreItem[] findItemByFilters(ItemFilter[] itemFilters)
    {
        int count=0;
        int size = availableItems.length;
        boolean matchesAllFilters[] = new boolean[size];
        Arrays.fill(matchesAllFilters,true);
        for (int i=0; i<size; i++)
        {
            for (ItemFilter filter : itemFilters)
            {
                if (!filter.matches(availableItems[i]))
                {
                    matchesAllFilters[i] = false;
                    break; // No need to check other filters for this item
                }
            }
            if (matchesAllFilters[i])
            {
                count++;
            }

        }
        StoreItem[] filteredItems = new StoreItem[count];
        int index = 0;
        for (int i = 0; i < size; i++)
        {
            if (matchesAllFilters[i]) {
                filteredItems[index++] = availableItems[i];
            }
        }
        return filteredItems;

    }

    private BigDecimal getDiscountMultiplier(String promoCode)
    {
        return switch (promoCode) {
            case "VAN40" -> new BigDecimal("0.6"); // 40% discount
            case "100YO" -> BigDecimal.ZERO; // 100% discount (free)
            default -> null;
        };
    }
    @Override
    public void applyDiscount(String promoCode)
    {
        BigDecimal discountMultiplier = getDiscountMultiplier(promoCode);
        if(discountMultiplier == null)
        {
            throw new IllegalArgumentException("Invalid promo code: " + promoCode);
        }
        for(StoreItem item :availableItems)
        {
            item.setPrice(item.getPrice().multiply(discountMultiplier));
        }



    }

    @Override
    public boolean rateItem(StoreItem item, int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }

        for (StoreItem availableItem : availableItems) {
            if (availableItem.equals(item)) {
                availableItem.rate(rating);
                return true;
            }
        }

        return false;
    }
}
