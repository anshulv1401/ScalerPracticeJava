import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory<T extends Item> {
    HashMap<String, T> items = new HashMap<>();
    RecentlyViewedItems<T> recentlyViewedItems = new RecentlyViewedItems<>();

    public void addItem(T item) {
        items.put(item.id, item);
    }

    public void addItems(List<T> item) {
        for (T i: item){
            addItem(i);
        }
    }

    public T getItem(String id) {
        T item = items.get(id);
        recentlyViewedItems.updateRecentlyViewedList(item);
        return item;
    }

    public void removeItem(String id) {
        items.remove(id);
    }

    public List<T> getAllItems() {
        return new ArrayList<>(items.values());
    }

    public List<T> getRecentlyViewedItems() {
        return recentlyViewedItems.getRecentlyViewedItems();
    }
}
