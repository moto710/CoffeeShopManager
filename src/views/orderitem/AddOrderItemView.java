package views.orderitem;

import models.OrderItem;
import service.OrderItemService;
import service.ProductService;
import views.OrderItemView;
import views.product.functionview.ShowAllProduct;
import viewtemplate.OrderItemTemplate;
import models.Product;

import static viewtemplate.ProductTemplate.productManagement;


public class AddOrderItemView extends OrderItemTemplate {
    public AddOrderItemView() {

    }

    @Override
    protected void showBody() {
        boolean flag = true;
        System.out.println("Add new order item:");
        System.out.println("----------------");

        ShowAllProduct showAllProduct = new ShowAllProduct();

        System.out.println("Choose product's ID:");
        System.out.println("===>");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Enter product's quantity:");
        long quantity = Long.parseLong(scanner.nextLine());

        OrderItem orderItem = new OrderItem(id, quantity);
        OrderItemService.addOrderItem(orderItem);

        do {
            System.out.println("Do you want to buy more product?");
            System.out.println("Yes/No (y/n)");
            String confirm = scanner.nextLine();
            switch (confirm) {
                case "y":
                case "Y":
                    System.out.println("Choose product's ID:");
                    id = Long.parseLong(scanner.nextLine());

                    System.out.println("Enter product's quantity:");
                    quantity = Long.parseLong(scanner.nextLine());

                    orderItem = new OrderItem(id, quantity);
                    OrderItemService.addOrderItem(orderItem);
                    break;
                case "n":
                case "N":
                    flag = false;
                    break;
            }
        }while (flag);

        OrderItemView orderItemView = new OrderItemView();


    }
}
