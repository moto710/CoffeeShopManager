package models;

import java.util.Date;

import static utils.DateUtils.formatDateToString;

public class Order {
    private long idOrder;
    private long idCart;
    private long idCustomer;
    private String dateCreate;

    public Order() {
    }

    public Order(long idOrder, long idCart, long idCustomer, String dateCreate) {
        this.idOrder = idOrder;
        this.idCart = idCart;
        this.idCustomer = idCustomer;
        this.dateCreate = dateCreate;
    }

    public Order(long idCart, long idCustomer, String dateCreate) {
        this.idOrder = System.currentTimeMillis()%1000000;
        this.idCart = idCart;
        this.idCustomer = idCustomer;
        this.dateCreate = formatDateToString(new Date());
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public long getIdCart() {
        return idCart;
    }

    public void setIdCart(long idCart) {
        this.idCart = idCart;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public static Order parseOrder(String raw) {
        String[] fields = raw.split(",");
        long id = Long.parseLong(fields[0]);
        long idCart = Long.parseLong(fields[1]);
        long idCustomer = Long.parseLong(fields[2]);
        String dateCreate = fields[3];
        Order order = new Order(id, idCart, idCustomer, dateCreate);

        return order;
    }

    public String toString() {
        return String.format("%s,%s,%s,%s", idOrder, idCart, idCustomer, dateCreate);
    }
}
