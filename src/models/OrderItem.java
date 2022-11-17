package models;

import service.ProductService;

public class OrderItem {
    private long idOrderItem;
    private long idProduct;
    private long quantity;
    private long total;
    public OrderItem() {
    }

    public OrderItem(long idOrderItem, long idProduct, long quantity, long total) {
        this.idOrderItem = idOrderItem;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.total = total;
    }
    public OrderItem(long idProduct, long quantity) {
        this.idOrderItem = System.currentTimeMillis()%1000000;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.total = (long) (quantity * ProductService.getProduct(idProduct).getPrice());
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

    public Long getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(Long idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", idOrderItem, idProduct, quantity, total);
    }
    public static OrderItem parseOrderItem(String raw) {
        String[] fields = raw.split(",");
        long id = Long.parseLong(fields[0]);
        long idProduct = Long.parseLong(fields[1]);
        long quantity = Long.parseLong(fields[2]);
        long total = Long.parseLong(fields[3]);

        OrderItem orderItem = new OrderItem(id, idProduct, quantity, total);

        return orderItem;
    }
}
