package order.cart;

import order.orderitem.OrderItem;
import java.util.List;

import static order.orderitem.OrderItem.parseOrderItem;

public class Cart {
    private long id;
    private OrderItem orderItem;
    private int totalOrderItem;
    private double grandTotal;

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public int getTotalOrderItem() {
        return totalOrderItem;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public long getId() {
        return id;
    }

    public Cart() {
    }

    public Cart(long id, OrderItem orderItem, int totalOrderItem, double grandTotal) {
        this.id = id;
        this.orderItem = orderItem;
        this.totalOrderItem = totalOrderItem;
        this.grandTotal = grandTotal;
    }
    public static Cart ParseCart(String raw) {
        String[] fields = raw.split(",");
        long id = Long.parseLong(fields[0]);
        OrderItem orderItemList = parseOrderItem(fields[1]);
        int totalOrderItem = Integer.parseInt(fields[2]);
        double grandTotal = Double.parseDouble(fields[3]);


        Cart cart = new Cart(id, orderItemList, totalOrderItem, grandTotal);

        return cart;
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",id, orderItem, totalOrderItem, grandTotal);
    }
}
