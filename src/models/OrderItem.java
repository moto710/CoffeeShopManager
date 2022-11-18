package models;

import service.ProductService;

import static service.OrderItemService.countGrandTotal;

public class OrderItem {
    private long idOrderItem;
    private long idProduct;
    private long quantity;
    private long total;
    private long grandTotal;
    public OrderItem() {
    }
    public OrderItem(long idOrderItem, long idProduct, long quantity, long total, long grandTotal) {
        this.idOrderItem = idOrderItem;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.total = total;
        this.grandTotal = grandTotal;
    }
    public OrderItem(long idOrderItem, long idProduct, long quantity, long total) {
        this.idOrderItem = idOrderItem;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.total = total;
        this.grandTotal = countGrandTotal();
    }
    public OrderItem(long idProduct, long quantity) {
        this.idOrderItem = System.currentTimeMillis()%1000000;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.total = (long) (quantity * ProductService.getProduct(idProduct).getPrice());
        this.grandTotal = countGrandTotal();
    }

    public long getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(long grandTotal) {
        this.grandTotal = grandTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public long getQuantity() {
        return quantity;
    }

    public void setIdOrderItem(long idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public long getIdOrderItem() {
        return idOrderItem;
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", idOrderItem, idProduct, quantity, total, grandTotal);
    }
    public static OrderItem parseOrderItem(String raw) {
        String[] fields = raw.split(",");
        long id = Long.parseLong(fields[0]);
        long idProduct = Long.parseLong(fields[1]);
        long quantity = Long.parseLong(fields[2]);
        long total = Long.parseLong(fields[3]);
        long grandTotal = Long.parseLong(fields[4]);

        OrderItem orderItem = new OrderItem(id, idProduct, quantity, total, grandTotal);

        return orderItem;
    }
}
