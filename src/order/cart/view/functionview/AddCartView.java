package order.cart.view.functionview;

import order.cart.Cart;
import order.cart.view.CartTemplate;
import order.orderitem.OrderItem;
import product.Product;

import static product.view.ProductTemplate.productManagement;

public class AddCartView extends CartTemplate {
    public AddCartView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Add a new cart:");
        System.out.println("----------------");
        System.out.println("Choose product by ID:");
        long id = Long.parseLong(scanner.nextLine());
        Product product = productManagement.searchId(id);

        System.out.println("Enter product's quantity:");
        float quantity = Float.parseFloat(scanner.nextLine());



        Cart cart = new Cart(product, quantity);
        orderItemManagement.addOrderItem(orderItem);

        System.out.println(orderItem);
    }
}
