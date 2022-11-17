package viewtemplate;

import models.Cart;
import service.CartService;
import viewtemplate.ViewTemplate;

import java.util.Comparator;
import java.util.List;

public abstract class CartTemplate extends ViewTemplate {
    protected static CartService cartManagement;

    protected Comparator<Cart> comparator;
    protected CartTemplate(){
        cartManagement = new CartService();
    }
    public static void showCart(List<Cart> carts){
        for (Cart item : carts) {
            System.out.println(item);
        }
    }
}
