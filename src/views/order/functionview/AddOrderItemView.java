package views.order.functionview;

import models.OrderItem;
import viewtemplate.OrderItemTemplate;
import models.Product;

import static viewtemplate.ProductTemplate.productManagement;


public class AddOrderItemView extends OrderItemTemplate {
    public AddOrderItemView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Add new views.order item:");
        System.out.println("----------------");
        System.out.println("Choose views.product by ID:");
        long id = Long.parseLong(scanner.nextLine());
        Product product = productManagement.searchId(id);

        System.out.println("Enter views.product's quantity:");
        float quantity = Float.parseFloat(scanner.nextLine());



        OrderItem orderItem = new OrderItem(product, quantity);
        orderItemManagement.addOrderItem(orderItem);

        System.out.println(orderItem);
    }
}
