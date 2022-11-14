package order.orderitem;

import product.Product;

import static product.Product.parseProduct;

public class OrderItem {
    private long id;
    private Product product;
    private float quantity;
    private double total;
    public OrderItem() {
    }

    public OrderItem(long id, Product product, float quantity, double total) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }
    public OrderItem(Product product, float quantity, double total) {
        this.id = System.currentTimeMillis()%1000000;
        this.product = product;
        this.quantity = quantity;
        this.total = quantity * product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
    public float getQuantity() {
        return quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", id, product, quantity, total);
    }
    public static OrderItem parseOrderItem(String raw) {
        String[] fields = raw.split(",");
        long id = Long.parseLong(fields[0]);
        Product product = parseProduct(fields[1]);
        float quantity = Float.parseFloat(fields[2]);
        double total = Double.parseDouble(fields[3]);

        OrderItem orderItem = new OrderItem(id, product, quantity, total);

        return orderItem;
    }
}
