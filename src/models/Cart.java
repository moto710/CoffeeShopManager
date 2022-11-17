package models;

import java.util.Date;

import static models.OrderItem.parseOrderItem;
import static utils.DateUtils.formatDateToString;

public class Cart {
    private long id;
    private OrderItem orderItem;
    private int totalOrderItem;
    private double grandTotal;
    private String dateCreate;
    private String dateUpdate;

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

    public void setId(long id) {
        this.id = id;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public void setTotalOrderItem(int totalOrderItem) {
        this.totalOrderItem = totalOrderItem;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Cart() {
    }

    public Cart(long id, OrderItem orderItem, int totalOrderItem, double grandTotal, String dateCreate, String dateUpdate) {
        this.id = id;
        this.orderItem = orderItem;
        this.totalOrderItem = totalOrderItem;
        this.grandTotal = grandTotal;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }
    public Cart(OrderItem orderItem) {
        this.id = System.currentTimeMillis()%1000000;
        this.orderItem = orderItem;
        this.totalOrderItem = (int) orderItem.getQuantity();
        this.grandTotal = orderItem.getTotal();
        this.dateCreate = formatDateToString(new Date());
        this.dateUpdate = formatDateToString(new Date());
    }
    public static Cart ParseCart(String raw) {
        String[] fields = raw.split(",");
        long id = Long.parseLong(fields[0]);
        OrderItem orderItemList = parseOrderItem(fields[1]);
        int totalOrderItem = Integer.parseInt(fields[2]);
        double grandTotal = Double.parseDouble(fields[3]);
        String dateCreate = fields[4];
        String dateUpdate = fields[5];


        Cart cart = new Cart(id, orderItemList, totalOrderItem, grandTotal, dateCreate, dateUpdate);

        return cart;
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",id, orderItem, totalOrderItem, grandTotal, dateCreate, dateUpdate);
    }
}
