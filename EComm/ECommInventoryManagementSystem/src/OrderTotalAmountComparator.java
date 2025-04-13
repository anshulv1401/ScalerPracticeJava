import java.util.Comparator;

public class OrderTotalAmountComparator implements Comparator<Order> {

    //process higher
    @Override
    public int compare(Order o1, Order o2) {
        return  o2.getTotalAmount() - o1.getTotalAmount();
    }
}
