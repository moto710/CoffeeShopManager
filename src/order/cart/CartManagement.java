package order.cart;

import java.util.ArrayList;
import java.util.List;

public class CartManagement {
    private List<Cart> cartList;

    public CartManagement() {
        List<Cart> cartList = new ArrayList<>();
        this.cartList = cartList;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
