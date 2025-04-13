import java.util.LinkedList;
import java.util.List;

public class RecentlyViewedItems <T extends Item> {
    LinkedList<T> recentlyViewed = new LinkedList<>();

    public void updateRecentlyViewedList(T item) {
        //remove item if exists
        recentlyViewed.remove(item);

        //add to first
        recentlyViewed.addFirst(item);

        //if the size goes beyond 10, remove the last item
        if (recentlyViewed.size() > 4)
            recentlyViewed.removeLast();
    }

    public List<T> getRecentlyViewedItems() {
        return recentlyViewed.stream().toList();
    }
}
