package order.order;

import customer.Customer;
import order.cart.Cart;

import java.util.Date;

import static customer.Customer.parseCustomer;
import static order.cart.Cart.ParseCart;
import static utils.DateUtils.formatDateToString;

public class Order {
    private Long id;
    private Cart cart;
    private Customer customer;
    private String dateCreate;

    public Order() {
    }

    public Order(Long id, Cart cart, Customer customer, String dateCreate) {
        this.id = id;
        this.cart = cart;
        this.customer = customer;
        this.dateCreate = dateCreate;
    }

    public Order(Cart cart, Customer customer, String dateCreate) {
        this.id = System.currentTimeMillis()%1000000;
        this.cart = cart;
        this.customer = customer;
        this.dateCreate = formatDateToString(new Date());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        Cart cart = ParseCart(fields[1]);
        Customer customer = parseCustomer(fields[2]);
        String dateCreate = fields[3];
        Order order = new Order(id, cart, customer, dateCreate);

        return order;
    }

    public String toString() {
        return String.format("%s,%s,%s,%s", id, cart, customer, dateCreate);
    }
}
