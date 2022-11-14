package order.cart.view;

import order.cart.Cart;
import order.cart.CartManagement;
import order.orderitem.OrderItem;
import order.orderitem.OrderItemManagement;
import viewtemplate.ViewTemplate;

import java.util.Comparator;
import java.util.List;

public abstract class CartTemplate extends ViewTemplate {
    protected static CartManagement cartManagement;

    protected Comparator<Cart> comparator;
    protected CartTemplate(){
        cartManagement = new CartManagement();
    }
    public static void showCart(List<Cart> carts){
        for (Cart item : carts) {
            System.out.println(item);
        }
    }
}
