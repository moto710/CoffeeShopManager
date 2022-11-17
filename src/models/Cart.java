package models;

import java.util.Date;

import static models.OrderItem.parseOrderItem;
import static utils.DateUtils.formatDateToString;
import static utils.DateUtils.parseStringToDate;

public class Cart {
    private long idCart;
    private long idOrderItem;
    private long totalOrderItem;
    private long grandTotal;
    private String dateCreate;
    private String dateUpdate;


    public void setTotalOrderItem(long totalOrderItem) {
        this.totalOrderItem = totalOrderItem;
    }

    public long getTotalOrderItem() {
        return totalOrderItem;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(long grandTotal) {
        this.grandTotal = grandTotal;
    }

    public long getIdCart() {
        return idCart;
    }

    public void setIdCart(long idCart) {
        this.idCart = idCart;
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

    public long getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(long idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public Cart() {
    }


    public Cart(long idCart, long idOrderItem, long totalOrderItem, long grandTotal, String dateCreate, String dateUpdate) {
        this.idCart = idCart;
        this.idOrderItem = idOrderItem;
        this.totalOrderItem = totalOrderItem;
        this.grandTotal = grandTotal;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }
    public Cart(long idOrderItem, long totalOrderItem, long grandTotal) {
        this.idCart = System.currentTimeMillis()%1000000;
        this.idOrderItem = idOrderItem;
        this.totalOrderItem = totalOrderItem;
        this.grandTotal = grandTotal;
        this.dateCreate = formatDateToString(new Date());
        this.dateUpdate = formatDateToString(new Date());
    }
    public static Cart ParseCart(String raw) {
        String[] fields = raw.split(",");
        long idCart = Long.parseLong(fields[0]);
        long idOrderItem = Long.parseLong(fields[1]);
        long totalOrderItem = Long.parseLong(fields[2]);
        long grandTotal = Long.parseLong(fields[3]);
        String dateCreate = fields[4];
        String dateUpdate = fields[5];


        Cart cart = new Cart(idCart, idOrderItem, totalOrderItem, grandTotal, dateCreate, dateUpdate);

        return cart;
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", idCart, idOrderItem, totalOrderItem, grandTotal, dateCreate, dateUpdate);
    }
}
