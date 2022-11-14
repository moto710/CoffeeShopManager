package order.orderitem.orderitemview.functionview;

import order.orderitem.OrderItem;
import order.orderitem.orderitemview.OrderItemTemplate;
import product.Product;

import static product.view.ProductTemplate.productManagement;


public class AddOrderItemView extends OrderItemTemplate {
    public AddOrderItemView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Add new order item:");
        System.out.println("----------------");
        System.out.println("Choose product by ID:");
        long id = Long.parseLong(scanner.nextLine());
        Product product = productManagement.searchId(id);

        System.out.println("Enter product's quantity:");
        float quantity = Float.parseFloat(scanner.nextLine());



        OrderItem orderItem = new OrderItem(product, quantity);
        orderItemManagement.addOrderItem(orderItem);

        System.out.println(orderItem);
    }
}
