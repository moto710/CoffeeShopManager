package views.orderitem;

import models.OrderItem;
import viewtemplate.OrderItemTemplate;

public class RemoveOrderItemView extends OrderItemTemplate {
    public RemoveOrderItemView() {

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            System.out.println("Please enter order item's ID to remove:");
            Long id = Long.parseLong(scanner.nextLine());
            OrderItem temp = orderItemManagement.findIdOrderItem(id);

            if (temp == null) {
                System.out.println("The order item with id = " + id + " does not exist!");
                flag = true;
            } else {
                System.out.println("Are you sure to remove this order item? (Y/N)");
                String confirm = scanner.nextLine();
                switch (confirm) {
                    case "Y":
                    case "y":
                        orderItemManagement.removeOrderItem(id);
                        break;
                    case "N":
                    case "n":
                        break;
                    default:
                        System.out.println("Try again!!");
                        break;
                }
            }
        } while (flag);
    }
}
